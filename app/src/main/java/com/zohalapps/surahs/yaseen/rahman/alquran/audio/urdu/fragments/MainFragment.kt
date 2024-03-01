package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.doOnPreDraw
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.ID
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.BannerAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.MyInterstitialAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.dialogFragment.ExitDialog
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.enums.MainMode.HomeMode
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentMainBinding

private const val TAG = "MainFragmentXX"
class MainFragment : Fragment(), HomeListener {
    private var _mainBinding: FragmentMainBinding? = null
    private val mainBinding get() = _mainBinding!!

    private var homeFragment: HomeFragment? = null
    private var settingFragment: SettingFragment? = null


    private val banner by lazy {
        BannerAd(requireContext(), lifecycle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _mainBinding = FragmentMainBinding.inflate(inflater, container, false)

        homeFragment = HomeFragment()
        settingFragment = SettingFragment()


        homeFragment?.let {
            it.setHomeListener(this)
            setCurrentFragment(it)
        }

        mainBinding.root.viewTreeObserver.addOnWindowFocusChangeListener {
            if (it) {
                askNotificationPermission()
            }
        }


        mainBinding.root.doOnPreDraw {

            showBannerAd()

        }



        return mainBinding.root
    }


    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.POST_NOTIFICATIONS
                ) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
                Log.d(TAG, "askNotificationPermission: permission granted")
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                AlertDialog.Builder(requireContext())
                    .setMessage("Permission is required to provide full functionality of app.")
                    .setPositiveButton("Ok") { dialog, _ ->
                        openSettings()
                        dialog.dismiss()
                    }
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }

    }

    private fun openSettings() {
        try {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val packageName = requireContext().packageName
            if (packageName != null) {
                val uri = Uri.parse("package:$packageName")
                intent.data = uri
                startActivity(intent)
            } else {

                Toast.makeText(requireContext(), "Package name is null", Toast.LENGTH_SHORT).show()
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.
            Log.d(TAG, "granted successfully: ")
        } else {
            // Check
        }
    }



    private fun showBannerAd() {
        banner.loadBanner {
            showAd(it)
        }
    }

    private fun showAd(adView: AdView) {
        if (adView.parent != null) {
            (adView.parent as ViewGroup).removeView(adView)
        }
        mainBinding.mainBanner.ad.visibility = View.GONE
        mainBinding.mainBanner.advertisement.visibility = View.GONE
        mainBinding.mainBanner.bannerContainer.addView(adView)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindListener()
    }

    private fun bindListener() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )

        mainBinding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                ID.home -> {
                    homeFragment?.let { home -> setCurrentFragment(home) }

                    return@setOnItemSelectedListener true
                }

                ID.setting -> {

                    settingFragment?.let { setting -> setCurrentFragment(setting) }
                    return@setOnItemSelectedListener true
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        parentFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                com.bumptech.glide.R.animator.fragment_fade_enter,
                com.bumptech.glide.R.animator.fragment_fade_exit
            )
            replace(ID.container, fragment)
            commit()
        }


    override fun onHomeClick(value: HomeMode) {
        val bundle = Bundle()
        when (value) {
            HomeMode.ALLAH -> {
                bundle.putString("names", HomeFragment.allahName)
                navigateToNames(bundle)
            }

            HomeMode.PROPHET -> {
                bundle.putString("names", HomeFragment.prophetName)
                navigateToNames(bundle)
            }

            HomeMode.REHMAN -> {
                bundle.putString("surahName", HomeFragment.rehman)
                navigateToSurah(bundle)
            }

            HomeMode.YASEEN -> {
                bundle.putString("surahName", HomeFragment.yaseen)
                navigateToSurah(bundle)
            }

            HomeMode.CALENDER -> {
                findNavController().navigate(ID.homeToCalender)
            }

            HomeMode.COUNTER -> {
                findNavController().navigate(ID.homeToTasbeeh)
            }

            HomeMode.KALMA -> {
                findNavController().navigate(ID.homeToQalma)
            }


            HomeMode.QIBLA -> {
                findNavController().navigate(ID.homeToQibla)
            }

            HomeMode.QUL -> {
                findNavController().navigate(ID.homeToQul)
            }


            HomeMode.SUPPLICATION -> {
                findNavController().navigate(ID.homeToSupp)
            }
        }

        if (MyInterstitialAd.mInterstitialAd != null) {
            MyInterstitialAd.mInterstitialAd?.show(requireActivity())
        }
    }

    private fun navigateToNames(bundle: Bundle) {
        findNavController().navigate(ID.homeToNames, bundle)
    }

    private fun navigateToSurah(bundle: Bundle) {
        findNavController().navigate(ID.homeToSurah, bundle)
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {

            settingFragment?.let {
                if (it.isAdded) {
                    mainBinding.bottomNavigation.selectedItemId = ID.home
                    homeFragment?.let { home -> setCurrentFragment(home) }

                } else {
                    val exitDialog = ExitDialog()
                    exitDialog.show(childFragmentManager)
                }
            }


        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _mainBinding = null
    }


}