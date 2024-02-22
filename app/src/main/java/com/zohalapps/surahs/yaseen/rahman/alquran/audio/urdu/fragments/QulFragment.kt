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
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.QulAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.BannerAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.QulModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.Extension.addCarouselEffect
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.viewModel.MainVM
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentQulBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QulFragment : Fragment() {
    private var _qulBinding: FragmentQulBinding? = null
    private val qulBinding get() = _qulBinding!!

    private val mainVM by viewModels<MainVM<QulModel>>()

    private val banner by lazy {
        BannerAd(requireContext(), lifecycle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _qulBinding = FragmentQulBinding.inflate(inflater, container, false)
        CoroutineScope(Dispatchers.Main).launch {
            mainVM.getQul()
        }

        qulBinding.root.doOnPreDraw{
                showAd()
        }
        return qulBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindListener()
        bindObserver()


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
        qulBinding.qulBanner.ad.visibility = View.GONE
        qulBinding.qulBanner.advertisement.visibility = View.GONE
        qulBinding.qulBanner.bannerContainer.addView(adView)
    }

    private fun bindListener() {
        qulBinding.qulHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(it: List<QulModel>) {
        val adp = QulAdp(it)
        qulBinding.qulVP.addCarouselEffect()
        qulBinding.qulVP.adapter = adp
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _qulBinding = null
    }

}