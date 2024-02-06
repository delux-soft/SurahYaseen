package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.surahyaseen.activities.ID
import com.example.surahyaseen.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _homeBinding: FragmentHomeBinding? = null
    private val homeBinding get() = _homeBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _homeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindListeners()
    }

    private fun bindListeners() {
        val bundle = Bundle()
        homeBinding.apply {

            surahYaseen.setOnClickListener {
                bundle.putString("surahName", yaseen)
                navigateToSurah(bundle)

            }

            surahRehman.setOnClickListener {
                bundle.putString("surahName", rehman)
                navigateToSurah(bundle)

            }

            allahNames.setOnClickListener {
                bundle.putString("name", allahName)
                navigateToNames(bundle)
            }

            prophetNames.setOnClickListener {
                bundle.putString("name", prophetName)
                navigateToNames(bundle)
            }
        }
    }

    private fun navigateToNames(bundle: Bundle) {
        findNavController().navigate(ID.homeToNames, bundle)
    }

    private fun navigateToSurah(bundle: Bundle) {
        findNavController().navigate(ID.homeToSurah, bundle)
    }


    companion object {
        const val yaseen = "Yaseen"
        const val rehman = "Rehman"
        const val allahName = "Allah"
        const val prophetName = "Prophet"
    }


}