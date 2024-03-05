package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.IBinder
import android.util.Log


private const val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 10 // 10 meters

private const val MIN_TIME_BW_UPDATES = (1000 * 60).toLong()

class GPSTracker(private val context: Context) : Service(), LocationListener {

    init {
        getLocation()
    }

    // flag for GPS status
    private var isGPSEnabled = false

    // flag for network status
    private var isNetworkEnabled = false

    // flag for GPS status
    private var canGetLocation = false
    private var location: Location? = null // location

    var lat = 0.0 // latitude

    var long = 0.0 // longitude


    private var locationManager: LocationManager? = null


    @SuppressLint("MissingPermission")
    private fun getLocation() {
        try {
            locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

            // getting GPS status

            isGPSEnabled = locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)

            // getting network status
            isNetworkEnabled = locationManager!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            if (isGPSEnabled || isNetworkEnabled) {
                canGetLocation = true
                if (isNetworkEnabled) {
                    locationManager!!.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        MIN_TIME_BW_UPDATES,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this
                    )
                    Log.d("Network", "Network")
                    if (locationManager != null) {
                        location = locationManager!!
                            .getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                        if (location != null) {
                            lat = location!!.latitude
                            long = location!!.longitude
                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled)
                    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        || checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    ) {
                        locationManager!!.removeUpdates(this)
                    }
                run {
                    if (location == null) {
                        assert(locationManager != null)
                        locationManager!!.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this
                        )
                        Log.d("GPS Enabled", "GPS Enabled")
                        if (locationManager != null) {
                            location = locationManager!!
                                .getLastKnownLocation(LocationManager.GPS_PROVIDER)
                            if (location != null) {
                                lat = location!!.latitude
                                long = location!!.longitude
                            }
                        }
                    }
                }

            } else {
                // no network provider is enabled
                Log.i("GpsTracker", "no network provider is enabled")
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun getLatitude(): Double {
        if (location != null) {
            lat = location!!.latitude
        }
        return lat
    }

    fun getLongitude(): Double {
        if (location != null) {
            long = location!!.longitude
        }
        return long
    }


    override fun onLocationChanged(p0: Location) {

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onProviderDisabled(provider: String) {
        super.onProviderDisabled(provider)
        if (provider == LocationManager.GPS_PROVIDER) {
            // GPS provider is disabled
            Log.i("GPSTracker", "GPS provider disabled")
            // You can show a message to the user indicating that GPS is disabled
            // or prompt the user to enable GPS
        } else if (provider == LocationManager.NETWORK_PROVIDER) {
            // Network provider is disabled
            Log.i("GPSTracker", "Network provider disabled")
            // You can show a message to the user indicating that network location services are disabled
            // or prompt the user to enable network location services
        }
    }


}