package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.ID
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.drawable
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.SurahAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.BannerAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.SurahModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.viewModel.MainVM
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentSurahBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "SurahFragmentXX"

class SurahFragment : Fragment() {
    private var _surahBinding: FragmentSurahBinding? = null
    private val surahBinding get() = _surahBinding!!

    private val mainVM by viewModels<MainVM<SurahModel>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private val banner by lazy {
        BannerAd(requireContext(), lifecycle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _surahBinding = FragmentSurahBinding.inflate(inflater, container, false)

        surahBinding.root.doOnPreDraw {
            showAd()
        }


        coroutineScope.launch {
            val argument = arguments?.getString("surahName", "")
            Log.d(TAG, "onCreateView: $argument")
            argument?.let {
                if (it.isNotEmpty()) {
                    when (it) {

                        HomeFragment.yaseen -> {
                            surahBinding.headInner.setImageResource(drawable.yaseen)
                            mainVM.getYaseenList()
                        }

                        HomeFragment.rehman -> {
                            surahBinding.headInner.setImageResource(drawable.rehman)
                            mainVM.getRehmanList()
                        }
                    }
                }
            }
        }
        return surahBinding.root
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
        surahBinding.surahBanner.ad.visibility = View.GONE
        surahBinding.surahBanner.advertisement.visibility = View.GONE
        surahBinding.surahBanner.bannerContainer.addView(adView)
    }

    private fun bindListener() {
        surahBinding.surahHeader.settings.setOnClickListener {
            findNavController().navigate(ID.surahToSetting)
        }
        surahBinding.surahHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(list: List<SurahModel>) {
        val adp = SurahAdp(this, list)
        surahBinding.surahVP.adapter = adp
        surahBinding.surahVP.setCurrentItem(list.size - 1, true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _surahBinding = null
    }
}