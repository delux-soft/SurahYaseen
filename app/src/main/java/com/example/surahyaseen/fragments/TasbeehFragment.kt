package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.surahyaseen.adapters.TasbeehAdp
import com.example.surahyaseen.databinding.FragmentTasbeehBinding
import com.example.surahyaseen.model.TasbeehModel
import com.example.surahyaseen.utils.Extension.addCarouselEffect
import com.example.surahyaseen.viewModel.MainVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TasbeehFragment : Fragment() {
    private var _tasbeehBinding: FragmentTasbeehBinding? = null

    private val tasbeehBinding get() = _tasbeehBinding!!

    private val mainVM by viewModels<MainVM<TasbeehModel>>()

    private var adp: TasbeehAdp? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _tasbeehBinding = FragmentTasbeehBinding.inflate(inflater, container, false)
        CoroutineScope(Dispatchers.Main).launch {
            mainVM.getTasbeeh()
        }
        return tasbeehBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()

        tasbeehBinding.tabFab.setOnClickListener {
            val index = tasbeehBinding.tasbeehVP.currentItem
            adp?.changeValue(index)
        }

        tasbeehBinding.resetFab.setOnClickListener {
            val index = tasbeehBinding.tasbeehVP.currentItem
            adp?.reset(index)
        }
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(it: List<TasbeehModel>) {
        adp = TasbeehAdp(it)
        tasbeehBinding.tasbeehVP.addCarouselEffect()
        tasbeehBinding.tasbeehVP.adapter = adp

    }


}