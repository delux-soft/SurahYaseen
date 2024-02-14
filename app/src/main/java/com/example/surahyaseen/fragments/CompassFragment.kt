package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.surahyaseen.R
import com.example.surahyaseen.databinding.FragmentCompassBinding
import com.example.surahyaseen.utils.GPSTracker
import com.example.surahyaseen.viewModel.CompassVM

class CompassFragment : Fragment() {
    private var _compassBinding: FragmentCompassBinding? = null
    private val compassBinding get() = _compassBinding!!

    private val compassViewModel by viewModels<CompassVM>()

    private var gps: GPSTracker? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _compassBinding = FragmentCompassBinding.inflate(inflater, container, false)
        return compassBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()
        setupSystemService()
    }

    private fun setupSystemService() {

    }

    private fun bindObserver() {
        compassViewModel.azimuth.observe(viewLifecycleOwner) {
            compassBinding.compass.setAzimuth(it.degrees)
        }
    }

}