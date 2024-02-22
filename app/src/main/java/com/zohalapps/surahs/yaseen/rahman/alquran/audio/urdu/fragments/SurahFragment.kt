package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.ID
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.drawable
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.SurahAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.BannerAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentSurahBinding
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.SurahModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.viewModel.MainVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "SurahFragmentXX"

class SurahFragment : Fragment() {
    private var _surahBinding: FragmentSurahBinding? = null
    private val surahBinding get() = _surahBinding!!

    private val mainVM by viewModels<MainVM<SurahModel>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private var currentPosition = 0

    private val banner by lazy {
        BannerAd(requireContext(), lifecycle)
    }

    private var mediaPlayer: MediaPlayer? = null

    private val list: MutableList<SurahModel> = mutableListOf()

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

        surahBinding.surahHeader.playPause.setOnClickListener {
            surahBinding.surahHeader.playPause.isActivated =
                !surahBinding.surahHeader.playPause.isActivated

            mediaPlayer?.let {
                if (it.isPlaying) {
                    it.pause()
                } else {
                    if (surahBinding.surahHeader.speaker.isActivated) {
                        surahBinding.surahHeader.speaker.isActivated = false
                    }
                    it.start()
                }
            }
        }

        surahBinding.surahHeader.speaker.setOnClickListener {
            surahBinding.surahHeader.speaker.isActivated =
                !surahBinding.surahHeader.speaker.isActivated

            mediaPlayer?.let {
                if (it.isPlaying) {
                    it.pause()
                } else {
                    if (!surahBinding.surahHeader.speaker.isActivated && surahBinding.surahHeader.playPause.isActivated) {
                        it.start()
                    }

                }
            }
        }
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            currentPosition = it.lastIndex
            list.addAll(it)
            setAdp(it)

        }
    }

    private fun setAdp(list: List<SurahModel>) {
        val adp = SurahAdp(this, list)
        surahBinding.surahVP.adapter = adp
        surahBinding.surahVP.setCurrentItem(list.lastIndex, true)
        surahBinding.surahVP.setPageTransformer { _, _ ->
            val index = surahBinding.surahVP.currentItem
            if (currentPosition != index) {
                currentPosition = index
                changeEveryThing(currentPosition)
            }
        }
        mediaPlayer = MediaPlayer.create(requireContext(), list[list.lastIndex].sound)
    }


    private fun changeEveryThing(position: Int) {
        Log.d(TAG, "changeEveryThing: $position")
        releaseMediaPlayer()
        surahBinding.surahVP.setCurrentItem(position, true)
        mediaPlayer = MediaPlayer.create(requireContext(), list[position].sound)
        mediaPlayer?.start()
        surahBinding.surahHeader.playPause.isActivated = true
        mediaPlayer?.setOnCompletionListener {
            var soundPosition = position - 1
            surahBinding.surahVP.setCurrentItem(soundPosition, true)
            if (soundPosition <= -1) {
                soundPosition = 10
                surahBinding.surahVP.setCurrentItem(soundPosition, true)

                mediaPlayer?.pause()
                surahBinding.surahHeader.playPause.isActivated = true
            }
        }
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            it.reset()
            mediaPlayer = null
        }
    }


    override fun onPause() {
        super.onPause()
        mediaPlayer?.let {
            it.pause()
            surahBinding.surahHeader.playPause.isActivated = false
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
        _surahBinding = null
    }
}