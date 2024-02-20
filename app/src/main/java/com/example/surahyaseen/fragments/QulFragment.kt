package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.surahyaseen.R
import com.example.surahyaseen.adapters.QulAdp
import com.example.surahyaseen.databinding.FragmentQulBinding
import com.example.surahyaseen.model.QalmaModel
import com.example.surahyaseen.model.QulModel
import com.example.surahyaseen.utils.Extension.addCarouselEffect
import com.example.surahyaseen.viewModel.MainVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QulFragment : Fragment() {
    private var _qulBinding: FragmentQulBinding? = null
    private val qulBinding get() = _qulBinding!!

    private val mainVM by viewModels<MainVM<QulModel>>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _qulBinding = FragmentQulBinding.inflate(inflater, container, false)
        CoroutineScope(Dispatchers.Main).launch {
            mainVM.getQul()
        }
        return qulBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()
        qulBinding.qulHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(it: List<QulModel>) {
        val adp = QulAdp(it)
        qulBinding.qulVP.addCarouselEffect()
        qulBinding.qulVP.adapter = adp
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _qulBinding = null
    }

}