package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.surahyaseen.R
import com.example.surahyaseen.databinding.FragmentQalmaBinding


class QalmaFragment : Fragment() {
    private var _qalmaBinding: FragmentQalmaBinding? = null
    private val qalmaBinding get() = _qalmaBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _qalmaBinding = FragmentQalmaBinding.inflate(layoutInflater, container, false)
        return qalmaBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()

    }

    private fun bindObserver() {

    }
}