package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentSurahImageBinding

class SurahImageFragment(private val path: String) : Fragment() {
    private var _surahBinding: FragmentSurahImageBinding? = null
    private val surahBinding get() = _surahBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _surahBinding = FragmentSurahImageBinding.inflate(inflater, container, false)

        return surahBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireActivity()).load(path).into(surahBinding.imageView)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _surahBinding = null
    }
}