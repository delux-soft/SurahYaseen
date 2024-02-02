package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.surahyaseen.R
import com.example.surahyaseen.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _mainBinding: FragmentMainBinding? = null
    private val mainBinding get() = _mainBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _mainBinding = FragmentMainBinding.inflate(inflater, container, false)
        return mainBinding.root
    }

}