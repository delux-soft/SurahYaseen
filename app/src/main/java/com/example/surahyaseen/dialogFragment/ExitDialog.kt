package com.example.surahyaseen.dialogFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.surahyaseen.R
import com.example.surahyaseen.databinding.FragmentExitDialogBinding


class ExitDialog : DialogFragment() {
    private var _exitBinding: FragmentExitDialogBinding? = null
    private val exitBinding get() = _exitBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _exitBinding = FragmentExitDialogBinding.inflate(layoutInflater, container, false)
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

    fun show(fragmentManager: FragmentManager) {
        if (!isAdded) {
            fragmentManager.beginTransaction()
                .add(this, "Dialog")
                .commitAllowingStateLoss()
        }
    }
}