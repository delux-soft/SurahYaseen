package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.dialogFragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.RateUsDialogBinding

class RateUsDialog : DialogFragment() {
    private var _binding: RateUsDialogBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RateUsDialogBinding.inflate(layoutInflater, container, false)

        binding.apply {
            img1.setOnClickListener {

                img4.isActivated = false
                img3.isActivated = false
                img2.isActivated = false
                img1.isActivated = true
                img5.isActivated = false
            }
            img2.setOnClickListener {

                img4.isActivated = false
                img3.isActivated = false
                img2.isActivated = true
                img1.isActivated = true
                img5.isActivated = false
            }
            img3.setOnClickListener {

                img4.isActivated = false
                img3.isActivated = true
                img2.isActivated = true
                img1.isActivated = true
                img5.isActivated = false
            }
            img4.setOnClickListener {


                img4.isActivated = true
                img3.isActivated = true
                img2.isActivated = true
                img1.isActivated = true
                img5.isActivated = false
            }
            img5.setOnClickListener {

                img5.isActivated = true
                img4.isActivated = true
                img3.isActivated = true
                img2.isActivated = true
                img1.isActivated = true
            }

            no.setOnClickListener {
                dismiss()
            }
            yes.setOnClickListener {
                if (img1.isActivated && img2.isActivated && img3.isActivated && img4.isActivated) {
                    open("market://details?id=${context?.packageName}")
                    dismiss()
                } else {
                    dismiss()
                }

            }
        }


        return binding.root
    }

    private fun open(link: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                android.R.color.transparent
            )
        )
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

}