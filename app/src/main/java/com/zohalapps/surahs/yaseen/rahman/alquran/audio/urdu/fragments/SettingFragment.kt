package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.nativead.NativeAdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.string
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.MyNativeAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.repo.Constants
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentSettingBinding
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.dialogFragment.RateUsDialog
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.NetConnectivity

private const val TAG = "SettingFragmentXX"

class SettingFragment : Fragment() {
    private var _setBinding: FragmentSettingBinding? = null
    private val setBinding get() = _setBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _setBinding = FragmentSettingBinding.inflate(inflater, container, false)

        return setBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindListener()



        if (NetConnectivity.isOnline(requireContext())) {
            setBinding.nativeCard.visibility = View.VISIBLE
            setBinding.shimmerLayout.visibility = View.VISIBLE
            setBinding.shimmerLayout.startShimmerAnimation()
        }

        setBinding.root.doOnPreDraw {
            MyNativeAd.getNativeForHome(requireActivity()) { nativeAd ->
                showAd(nativeAd)
            }
        }




    }


    private fun showAd(nativeAdView: NativeAdView) {

        if (nativeAdView.parent != null) {
            (nativeAdView.parent as ViewGroup).removeView(nativeAdView)
        }
        Log.d(TAG, "showAd 2: $nativeAdView $_setBinding")
        _setBinding?.let {
            setBinding.shimmerLayout.stopShimmerAnimation()
            setBinding.shimmerLayout.visibility = View.GONE
            setBinding.nativeContainer.visibility = View.VISIBLE
            setBinding.nativeContainer.removeAllViews()
            setBinding.nativeContainer.addView(nativeAdView)
        }

    }

    private fun bindListener() {
        setBinding.apply {


            feedBack.setOnClickListener {
                val aEmailList = arrayOf(Constants.EMAIL)
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.setData(Uri.parse("mailto:")) // only email apps should handle this

                intent.putExtra(Intent.EXTRA_EMAIL, aEmailList)
                intent.putExtra(Intent.EXTRA_SUBJECT, Constants.SUBJECT)
                startActivity(Intent.createChooser(intent, "Send email..."))
            }
            rateUs.setOnClickListener {
                val rateDialog = RateUsDialog()
                rateDialog.show(childFragmentManager, "rate us")

            }
            more.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                val url = "https://play.google.com/store/apps/dev?id=7923419280829934943&hl=en"
                intent.setData(Uri.parse(url))
                startActivity(intent)
            }
            privacy.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                val url =
                    "https://docs.google.com/document/d/1yARNf2EgcgTtJqD0DgPrNEbf5_o42w5sxIQPSNFpoLQ/edit?usp=sharing"
                intent.setData(Uri.parse(url))
                startActivity(intent)
            }
            invite.setOnClickListener {
                val tell = Intent("android.intent.action.SEND")
                tell.type = "text/plain"
                tell.putExtra(
                    "android.intent.extra.TEXT",
                    """Try this awesome ${getString(string.app_name)} app,  http://play.google.com/store/apps/details?id=${requireContext().packageName}"""
                )

                startActivity(Intent.createChooser(tell, "Share using"))

            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _setBinding = null
    }


}