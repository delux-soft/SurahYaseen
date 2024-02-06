package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.surahyaseen.databinding.FragmentNamesBinding

class NamesFragment : Fragment() {
    private var _nameBinding: FragmentNamesBinding? = null
    private val nameBinding get() = _nameBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _nameBinding = FragmentNamesBinding.inflate(inflater, container, false)
        return nameBinding.root
    }


}