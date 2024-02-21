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
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.AdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.ID
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.SupplicationAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.BannerAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.MyInterstitialAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.app.MyApplication
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.SupplicationInnerModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.SupplicationModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.viewModel.MainVM
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentSupplicationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SupplicationFragment : Fragment() {
    private var _supplicationBinding: FragmentSupplicationBinding? = null
    private val supplicationBinding get() = _supplicationBinding!!


    private val mainVM by viewModels<MainVM<SupplicationModel>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

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
        _supplicationBinding = FragmentSupplicationBinding.inflate(layoutInflater, container, false)

        coroutineScope.launch {
            mainVM.getSupplication()
        }
        supplicationBinding.root.doOnPreDraw {

            showAd()

        }

        return supplicationBinding.root
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
        supplicationBinding.suppMainBanner.ad.visibility = View.GONE
        supplicationBinding.suppMainBanner.advertisement.visibility = View.GONE
        supplicationBinding.suppMainBanner.bannerContainer.addView(adView)
    }

    private fun bindListener() {
        supplicationBinding.suppMainHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(it: List<SupplicationModel>) {
        val adp = SupplicationAdp(it, ::onClick)
        supplicationBinding.supplicationRecycler.layoutManager =
            GridLayoutManager(requireContext(), 2)
        supplicationBinding.supplicationRecycler.adapter = adp
    }


    private fun onClick(model: SupplicationModel) {
        mutableList.clear()
        mutableList.addAll(model.list)
        val bundle = Bundle()
        bundle.putString("supplicationName", model.name)
        ++myApp.count
        Log.d("Count!", "onClick Main: ${myApp.count}")
        if (myApp.count % 2 == 0) {
            if (MyInterstitialAd.mInterstitialAd != null) {
                MyInterstitialAd.mInterstitialAd?.show(requireActivity())
            }
        }
        findNavController().navigate(ID.supplicationToInner, bundle)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Count!", "onDestroyView: ")

        _supplicationBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        myApp.count = 0
        Log.d("Count!", "onDestroy: ")
    }


    companion object {
        val mutableList: MutableList<SupplicationInnerModel> = mutableListOf()
    }


}