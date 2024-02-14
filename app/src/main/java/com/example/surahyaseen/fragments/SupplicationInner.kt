package com.example.surahyaseen.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.R
import com.example.surahyaseen.adapters.SupplicationInnerAdp
import com.example.surahyaseen.databinding.FragmentSupplicationInnerBinding
import com.example.surahyaseen.utils.Animation
import com.example.surahyaseen.utils.Extension.addCarouselEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "SupplicationInnerXX"

class SupplicationInner : Fragment() {
    private var _supplicationInnerBinding: FragmentSupplicationInnerBinding? = null

    private val supplicationInnerBinding get() = _supplicationInnerBinding!!

    private var vpAdp: SupplicationInnerAdp? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _supplicationInnerBinding =
            FragmentSupplicationInnerBinding.inflate(inflater, container, false)


        CoroutineScope(Dispatchers.IO).launch {
            val argument = arguments?.getString("supplicationName", "")

            argument?.let {
                if (it.isNotEmpty()) {
                    supplicationInnerBinding.name.text = argument
                }
            }
        }


        return supplicationInnerBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )
        setAdp()
        setVP()
    }

    private fun setVP() {
        vpAdp = SupplicationInnerAdp(1, SupplicationFragment.mutableList)
        supplicationInnerBinding.supplicationInnerVP.addCarouselEffect()
        supplicationInnerBinding.supplicationInnerVP.adapter = vpAdp
    }

    private fun setAdp() {
        val adp = SupplicationInnerAdp(0, SupplicationFragment.mutableList, ::onClick)
        supplicationInnerBinding.supplicationInnerRecycler.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        supplicationInnerBinding.supplicationInnerRecycler.adapter = adp
    }


    private fun onClick(position: Int) {
        Log.d(TAG, "onClick: $position")
        Animation.crossFade(
            requireContext(),
            supplicationInnerBinding.supplicationInnerVP,
            supplicationInnerBinding.supplicationInnerRecycler
        )
        supplicationInnerBinding.supplicationInnerVP.setCurrentItem(position, true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _supplicationInnerBinding = null
    }


    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (!supplicationInnerBinding.supplicationInnerRecycler.isVisible) {
                Animation.crossFade(
                    requireContext(),
                    supplicationInnerBinding.supplicationInnerRecycler,
                    supplicationInnerBinding.supplicationInnerVP
                )
            } else {
                findNavController().popBackStack()
            }

        }
    }


}