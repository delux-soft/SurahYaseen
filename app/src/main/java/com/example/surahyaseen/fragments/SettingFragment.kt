package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.surahyaseen.databinding.FragmentSettingBinding
import com.example.surahyaseen.enums.MainMode


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






}