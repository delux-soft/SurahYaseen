package com.example.surahyaseen.fragments

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Surface
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.surahyaseen.databinding.FragmentCompassBinding
import com.example.surahyaseen.enums.DisplayRotation
import com.example.surahyaseen.model.Azimuth
import com.example.surahyaseen.model.RotationVector
import com.example.surahyaseen.utils.GPSTracker
import com.example.surahyaseen.utils.MathUtils
import com.example.surahyaseen.viewModel.CompassVM
import kotlin.math.abs


private const val LOCATION_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION
private const val TAG = "CompassFragmentXX"

class CompassFragment : Fragment() {
    private var _compassBinding: FragmentCompassBinding? = null
    private val compassBinding get() = _compassBinding!!

    private var sensorManager: SensorManager? = null
    private var locationManager: LocationManager? = null
    private var gps: GPSTracker? = null

    private val compassSensorEventListener = CompassSensorEventListener()

    private val compassViewModel by viewModels<CompassVM>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _compassBinding = FragmentCompassBinding.inflate(inflater, container, false)
        requestLocation()
        return compassBinding.root
    }

    private fun requestLocation() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                LOCATION_PERMISSION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            locationPermission.launch(LOCATION_PERMISSION)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindObserver()
        setupSystemService()

        compassBinding.compassHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }


    private fun bindObserver() {
        compassViewModel.azimuth.observe(viewLifecycleOwner) {
            compassBinding.compass.setAzimuth(it.degrees)
        }
    }

    private fun setupSystemService() {
        sensorManager = ActivityCompat.getSystemService(requireContext(), SensorManager::class.java)
        locationManager =
            ActivityCompat.getSystemService(requireContext(), LocationManager::class.java)
    }


    override fun onResume() {
        super.onResume()
        gps = GPSTracker(requireContext())
        val locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val enabled =
            locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (enabled) {
            compassBinding.tvSetting.visibility = View.GONE
            compassBinding.setting.visibility = View.GONE
            compassBinding.latitudeText.text = convertLatitude(gps!!.lat)
            compassBinding.longitudeText.text = convertLongitude(gps!!.long)
        } else {
            compassBinding.tvSetting.visibility = View.VISIBLE
            compassBinding.setting.visibility = View.VISIBLE
            compassBinding.setting.setOnClickListener {
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                requireContext().startActivity(intent)
            }
        }
        registerSensorListener()


        Log.i(TAG, "Started compass")
    }

    private fun convertLatitude(latitude: Double): String {
        val builder = StringBuilder()
        if (latitude < 0) {
            builder.append("S ")
        } else {
            builder.append("N ")
        }
        val latitudeDegrees = Location.convert(abs(latitude), Location.FORMAT_SECONDS)
        val latitudeSplit = latitudeDegrees.split(":").toTypedArray()
        builder.append(latitudeSplit[0])
        builder.append("°")
        builder.append(latitudeSplit[1])
        builder.append("'")
        builder.append(latitudeSplit[2])
        builder.append("\"")
        builder.append(" ")
        return builder.toString()
    }

    private fun convertLongitude(longitude: Double): String {
        val builder = StringBuilder()
        if (longitude < 0) {
            builder.append("W ")
        } else {
            builder.append("E ")
        }
        val longitudeDegrees = Location.convert(abs(longitude), Location.FORMAT_SECONDS)
        val longitudeSplit = longitudeDegrees.split(":").toTypedArray()
        builder.append(longitudeSplit[0])
        builder.append("°")
        builder.append(longitudeSplit[1])
        builder.append("'")
        builder.append(longitudeSplit[2])
        builder.append("\"")
        return builder.toString()
    }

    private inner class CompassSensorEventListener : SensorEventListener {

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {

        }


        override fun onSensorChanged(event: SensorEvent) {
            when (event.sensor.type) {
                Sensor.TYPE_ROTATION_VECTOR -> updateCompass(event)
                else -> Log.w(TAG, "Unexpected sensor changed event of type ${event.sensor.type}")
            }
        }

        private fun updateCompass(event: SensorEvent) {
            val rotationVector = RotationVector(event.values[0], event.values[1], event.values[2])
            val displayRotation = getDisplayRotation()
            val magneticAzimuth = MathUtils.calculateAzimuth(rotationVector, displayRotation)

            if (compassViewModel.trueNorth.value == true) {
                val magneticDeclination = getMagneticDeclination()
                val trueAzimuth = magneticAzimuth.plus(magneticDeclination)
                setAzimuth(trueAzimuth)
            } else {
                setAzimuth(magneticAzimuth)
            }
        }

        private fun getDisplayRotation(): DisplayRotation {
            return when (getDisplayCompat()?.rotation) {
                Surface.ROTATION_90 -> DisplayRotation.ROTATION_90
                Surface.ROTATION_180 -> DisplayRotation.ROTATION_180
                Surface.ROTATION_270 -> DisplayRotation.ROTATION_270
                else -> DisplayRotation.ROTATION_0
            }
        }

        private fun getDisplayCompat(): Display? {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                activity?.display
            } else {
                activity?.windowManager?.defaultDisplay
            }
        }

        private fun getMagneticDeclination(): Float {
            return compassViewModel.location.value
                ?.let(MathUtils::getMagneticDeclination)
                ?: 0.0f
        }
    }

    private fun registerSensorListener() {
        sensorManager?.also { sensorManager ->
            sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
                ?.also { rotationVectorSensor ->
                    val success = sensorManager.registerListener(
                        compassSensorEventListener,
                        rotationVectorSensor,
                        SensorManager.SENSOR_DELAY_FASTEST
                    )
                    if (success) {
                        Log.d(TAG, "Registered listener for rotation vector sensor")
                    } else {
                        Log.w(TAG, "Could not enable rotation vector sensor")

                    }
                } ?: run {
                Log.w(TAG, "Rotation vector sensor not available")

            }
        } ?: run {
            Log.w(TAG, "SensorManager not present")

        }
    }


    internal fun setAzimuth(azimuth: Azimuth) {
        compassViewModel.azimuth.value = azimuth
        Log.v(TAG, "Azimuth $azimuth")
    }

    private var locationPermission: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {

        }


}