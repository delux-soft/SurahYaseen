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
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.string
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.BottomNumberAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.NameAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.BannerAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.NamesModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.Extension.addCarouselEffect
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.viewModel.MainVM
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentNamesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "NamesFragmentXX"

class NamesFragment : Fragment() {
    private var _nameBinding: FragmentNamesBinding? = null
    private val nameBinding get() = _nameBinding!!

    private val mainVM by viewModels<MainVM<NamesModel>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private var adp: BottomNumberAdp? = null

    private val banner by lazy {
        BannerAd(requireContext(),lifecycle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _nameBinding = FragmentNamesBinding.inflate(inflater, container, false)


        nameBinding.root.doOnPreDraw {
            showAd()
        }

        coroutineScope.launch {
            val argument = arguments?.getString("names", "")
            Log.d(TAG, "onCreateView: $argument")
            argument?.let {
                if (it.isNotEmpty()) {
                    when (it) {

                        HomeFragment.allahName -> {
                            nameBinding.name.setText(string.allah_names)
                            mainVM.getAllahNames()
                        }

                        HomeFragment.prophetName -> {
                            nameBinding.name.setText(string.prophet_names)
                            mainVM.getMuhammadName()
                        }
                    }
                }
            }
        }


        return nameBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()
        bindListener()
        
        nameBinding.root.viewTreeObserver.addOnWindowFocusChangeListener {
            Log.d(TAG, "onViewCreated: $it")
            if (it){
                showAd()
            }
        }

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
        nameBinding.namesBanner.ad.visibility = View.GONE
        nameBinding.namesBanner.advertisement.visibility = View.GONE
        nameBinding.namesBanner.bannerContainer.addView(adView)
    }

    private fun bindListener() {
        nameBinding.namesHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }
        nameBinding.namesHeader.settings.setOnClickListener {
            findNavController().navigate(ID.namesToSetting)
        }
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(it: List<NamesModel>) {
        val adapter = NameAdp()
        nameBinding.namesRecycler.addCarouselEffect()
        nameBinding.namesRecycler.adapter = adapter
        adapter.submitList(it)
        setBottomRecycler(it.size)
    }

    private fun setBottomRecycler(size: Int) {
        val list = mutableListOf<Int>()
        for (i in 1..size) {
            list.add(i)
        }

        adp = BottomNumberAdp(list) {
            smoothScroll(it)
        }

        adp?.let { nameBinding.numberRecycler.initialize(it) }


    }

    private fun smoothScroll(it: Int) {
        nameBinding.numberRecycler.smoothScrollToPosition(it)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _nameBinding = null
    }


}