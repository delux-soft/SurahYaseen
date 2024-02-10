package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.surahyaseen.R
import com.example.surahyaseen.databinding.FragmentSupplicationBinding
import com.example.surahyaseen.model.SupplicationModel
import com.example.surahyaseen.model.SurahModel
import com.example.surahyaseen.viewModel.MainVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SupplicationFragment : Fragment() {
    private var _supplicationBinding: FragmentSupplicationBinding? = null
    private val supplicationBinding get() = _supplicationBinding!!


    private val mainVM by viewModels<MainVM<SupplicationModel>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _supplicationBinding = FragmentSupplicationBinding.inflate(layoutInflater, container, false)

        coroutineScope.launch {

        }
        return supplicationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(it: List<SupplicationModel>) {

    }


}