package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.surahyaseen.adapters.QalmaAdp
import com.example.surahyaseen.databinding.FragmentQalmaBinding
import com.example.surahyaseen.model.QalmaModel
import com.example.surahyaseen.utils.Extension.addCarouselEffect
import com.example.surahyaseen.viewModel.MainVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class QalmaFragment : Fragment() {
    private var _qalmaBinding: FragmentQalmaBinding? = null
    private val qalmaBinding get() = _qalmaBinding!!

    private val mainVM by viewModels<MainVM<QalmaModel>>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _qalmaBinding = FragmentQalmaBinding.inflate(layoutInflater, container, false)
        CoroutineScope(Dispatchers.Main).launch {
            mainVM.getQalma()
        }
        return qalmaBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()
        qalmaBinding.qalmaHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(it: List<QalmaModel>) {
        val adapter = QalmaAdp()
        qalmaBinding.qalmaVP.addCarouselEffect()
        qalmaBinding.qalmaVP.adapter = adapter
        adapter.submitList(it)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _qalmaBinding = null
    }
}