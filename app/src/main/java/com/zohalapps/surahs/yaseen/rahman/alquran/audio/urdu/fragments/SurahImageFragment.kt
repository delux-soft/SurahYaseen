package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentSurahImageBinding

class SurahImageFragment : Fragment() {
    private var _surahBinding: FragmentSurahImageBinding? = null
    private val surahBinding get() = _surahBinding!!

    private val path: String
        get() = requireArguments().getString(PATH)
            ?: throw IllegalArgumentException("Argument required")

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

    companion object {

        private const val PATH = "path"
        fun newInstance(path: String) = SurahImageFragment().apply {
            arguments = bundleOf(
                PATH to path
            )
        }
    }
}