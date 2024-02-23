package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.doOnPreDraw
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.SupplicationInnerAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.BannerAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.MyInterstitialAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.app.MyApplication
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.Animation
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.Extension.addCarouselEffect
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentSupplicationInnerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SupplicationInner : Fragment() {
    private var _supplicationInnerBinding: FragmentSupplicationInnerBinding? = null

    private val supplicationInnerBinding get() = _supplicationInnerBinding!!

    private var vpAdp: SupplicationInnerAdp? = null

    private val banner by lazy {
        BannerAd(requireContext(), lifecycle)
    }


    private val myApp by lazy {
        requireActivity().application as MyApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _supplicationInnerBinding =
            FragmentSupplicationInnerBinding.inflate(inflater, container, false)


        CoroutineScope(Dispatchers.IO).launch {
            val argument1 = arguments?.getString("supplicationName", "")

            argument1?.let {
                if (it.isNotEmpty()) {
                    supplicationInnerBinding.name.text = it
                }
            }

        }
        supplicationInnerBinding.root.doOnPreDraw {
            showAd()
        }

        return supplicationInnerBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindListener()
        setAdp()
        setVP()


    }

    private fun showAd() {
        banner.loadBanner {
            showBannerAd(it)
        }
    }

    private fun showBannerAd(adView: AdView) {
        if (adView.parent != null) {
            (adView.parent as ViewGroup).removeView(adView)
        }
        supplicationInnerBinding.suppInnerBanner.ad.visibility = View.GONE
        supplicationInnerBinding.suppInnerBanner.advertisement.visibility = View.GONE
        supplicationInnerBinding.suppInnerBanner.bannerContainer.addView(adView)
    }

    private fun bindListener() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )
        supplicationInnerBinding.suppInnerHeader.back.setOnClickListener {
            onBackPress()
        }
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
        myApp.count++
        if (myApp.count % 2 == 0) {
            if (MyInterstitialAd.mInterstitialAd != null) {
                MyInterstitialAd.mInterstitialAd?.show(requireActivity())
            }
        }
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
            onBackPress()

        }
    }

    private fun onBackPress() {
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