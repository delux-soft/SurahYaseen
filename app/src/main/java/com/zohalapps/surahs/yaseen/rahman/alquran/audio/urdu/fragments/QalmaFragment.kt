package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.QalmaAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.BannerAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.QalmaModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.Extension.addCarouselEffect
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.viewModel.MainVM
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentQalmaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QalmaFragment : Fragment() {
    private var _qalmaBinding: FragmentQalmaBinding? = null
    private val qalmaBinding get() = _qalmaBinding!!

    private val mainVM by viewModels<MainVM<QalmaModel>>()

    private val banner by lazy {
        BannerAd(requireContext(), lifecycle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _qalmaBinding = FragmentQalmaBinding.inflate(layoutInflater, container, false)
        CoroutineScope(Dispatchers.Main).launch {
            mainVM.getQalma()
        }

        qalmaBinding.root.doOnPreDraw {
            showAd()
        }

        return qalmaBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()
        bindListener()


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
        qalmaBinding.qalmaBanner.ad.visibility = View.GONE
        qalmaBinding.qalmaBanner.advertisement.visibility = View.GONE
        qalmaBinding.qalmaBanner.bannerContainer.addView(adView)
    }

    private fun bindListener() {
        qalmaBinding.qalmaHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(it: List<QalmaModel>) {
        val adapter = QalmaAdp()
        qalmaBinding.qalmaVP.addCarouselEffect()
        qalmaBinding.qalmaVP.adapter = adapter
        adapter.submitList(it)
        qalmaBinding.qalmaVP.setCurrentItem(it.lastIndex, true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _qalmaBinding = null
    }
}