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
import androidx.viewpager2.widget.ViewPager2
import com.google.android.gms.ads.AdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.TasbeehAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.BannerAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.TasbeehModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.Extension.addCarouselEffect
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.viewModel.MainVM
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentTasbeehBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "TasbeehFragmentXX"

class TasbeehFragment : Fragment() {
    private var _tasbeehBinding: FragmentTasbeehBinding? = null

    private val tasbeehBinding get() = _tasbeehBinding!!

    private val mainVM by viewModels<MainVM<TasbeehModel>>()

    private var index = 0

    private var listSize = 0

    private var adp: TasbeehAdp? = null

    private val banner by lazy {
        BannerAd(requireContext(), lifecycle)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _tasbeehBinding = FragmentTasbeehBinding.inflate(inflater, container, false)
        CoroutineScope(Dispatchers.Main).launch {
            mainVM.getTasbeeh()
        }

        tasbeehBinding.root.doOnPreDraw {
            showAd()
        }
        return tasbeehBinding.root
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
        tasbeehBinding.tasbeehBanner.ad.visibility = View.GONE
        tasbeehBinding.tasbeehBanner.advertisement.visibility = View.GONE
        tasbeehBinding.tasbeehBanner.bannerContainer.addView(adView)
    }


    private fun bindListener() {
        tasbeehBinding.tabFab.setOnClickListener {
            val index = tasbeehBinding.tasbeehVP.currentItem
            adp?.changeValue(index)
        }

        tasbeehBinding.resetFab.setOnClickListener {
            val index = tasbeehBinding.tasbeehVP.currentItem
            adp?.reset(index)
        }

        tasbeehBinding.next.setOnClickListener {
            ++index
            Log.d(TAG, "bindListener: $index $listSize")
            if (index >= listSize) {
                --index
            } else {
                tasbeehBinding.tasbeehVP.setCurrentItem(index, true)
            }


        }

        tasbeehBinding.prev.setOnClickListener {
            --index
            Log.d(TAG, "bindListener: $index $listSize")
            if (index <= 0) {
                ++index
            } else {
                tasbeehBinding.tasbeehVP.setCurrentItem(index, true)
            }

        }

        tasbeehBinding.tasbeehHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(it: List<TasbeehModel>) {
        adp = TasbeehAdp(it)
        tasbeehBinding.tasbeehVP.addCarouselEffect()
        tasbeehBinding.tasbeehVP.adapter = adp
        listSize = it.size
        tasbeehBinding.tasbeehVP.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                val value = positionOffset.compareTo(0.0)
                if (value == 0) {
                    index = tasbeehBinding.tasbeehVP.currentItem
                }
            }
        })

    }


}