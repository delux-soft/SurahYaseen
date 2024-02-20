package com.example.surahyaseen.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.surahyaseen.R
import com.example.surahyaseen.databinding.FragmentSettingBinding
import com.example.surahyaseen.enums.MainMode
import com.example.surahyaseen.repo.Constants


interface SettingListener {
    fun onSettingClick(value: MainMode.SettingMode)
}

class SettingFragment : Fragment() {
    private var _setBinding: FragmentSettingBinding? = null
    private val setBinding get() = _setBinding!!

    private var listener: SettingListener? = null

    fun setSettingListener(listener: SettingListener) {
        this.listener = listener
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment\
        _setBinding = FragmentSettingBinding.inflate(inflater, container, false)

        return setBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindListener()
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
                val uri =
                    Uri.parse("market://details?id=${requireContext().packageName}")
                val rateAppIntent = Intent(Intent.ACTION_VIEW, uri)

                startActivity(rateAppIntent)

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
                    """Try this awesome ${getString(R.string.app_name)} app,  http://play.google.com/store/apps/details?id=${requireContext().packageName}"""
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