package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.surahyaseen.R
import com.example.surahyaseen.databinding.FragmentCalenderBinding

class CalenderFragment : Fragment() {
    private var _calenderBinding: FragmentCalenderBinding? = null
    private val calenderBinding get() = _calenderBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _calenderBinding = FragmentCalenderBinding.inflate(inflater, container, false)
        return calenderBinding.root
    }


}