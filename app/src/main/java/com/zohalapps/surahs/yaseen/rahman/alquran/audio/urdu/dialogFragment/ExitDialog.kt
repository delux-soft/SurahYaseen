package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.dialogFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.google.android.gms.ads.AdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.R
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.UltraInlineBanner
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentExitDialogBinding
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.NetConnectivity


class ExitDialog : DialogFragment() {
    private var _exitBinding: FragmentExitDialogBinding? = null
    private val exitBinding get() = _exitBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _exitBinding = FragmentExitDialogBinding.inflate(layoutInflater, container, false)

        exitBinding.root.doOnPreDraw {
            if (NetConnectivity.isOnline(requireContext())) {
                UltraInlineBanner.loadBanner(requireContext()) {
                    showAd(it)
                }
            }
        }
        return exitBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exitBinding.no.setOnClickListener {
            dismiss()
        }
        exitBinding.yes.setOnClickListener {
            requireActivity().finish()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.color.black_transparent
            )
        )
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
    }

    private fun showAd(adView: AdView?) {

        if (adView == null)
            return
        if (adView.parent != null) {
            (adView.parent as ViewGroup).removeView(adView)
        }

        exitBinding.ad.visibility = View.GONE
        exitBinding.advertisement.visibility = View.GONE

        exitBinding.adsContain.removeAllViews()
        exitBinding.adsContain.addView(adView)
    }


    fun show(fragmentManager: FragmentManager) {
        if (!isAdded) {
            fragmentManager.beginTransaction()
                .add(this, "Dialog")
                .commitAllowingStateLoss()
        }
    }
}