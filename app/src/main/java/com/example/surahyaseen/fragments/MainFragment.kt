package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.surahyaseen.activities.ID
import com.example.surahyaseen.databinding.FragmentMainBinding
import com.example.surahyaseen.enums.MainMode.SettingMode
import com.example.surahyaseen.enums.MainMode.HomeMode


class MainFragment : Fragment(), SettingListener, HomeListener {
    private var _mainBinding: FragmentMainBinding? = null
    private val mainBinding get() = _mainBinding!!

    private var homeFragment: HomeFragment? = null
    private var settingFragment: SettingFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _mainBinding = FragmentMainBinding.inflate(inflater, container, false)

        homeFragment = HomeFragment()
        settingFragment = SettingFragment()

        settingFragment?.setSettingListener(this)

        homeFragment?.let {
            it.setHomeListener(this)
            setCurrentFragment(it)
        }



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


        return mainBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )

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


    override fun onSettingClick(value: SettingMode) {
        when (value) {
            SettingMode.MORE -> {

            }

            SettingMode.FEEDBACK -> {

            }

            SettingMode.INVITE -> {

            }

            SettingMode.PRIVACY -> {

            }

            SettingMode.RATE -> {

            }
        }
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

            }

            HomeMode.COUNTER -> {

            }

            HomeMode.KALMA -> {
                findNavController().navigate(ID.homeToQalma)
            }


            HomeMode.QIBLA -> {

            }

            HomeMode.QUL -> {
                findNavController().navigate(ID.homeToQul)
            }


            HomeMode.SUPPLICATION -> {
                findNavController().navigate(ID.homeToSupp)
            }
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
                    requireActivity().finish()
                }
            }


        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _mainBinding = null
    }


}