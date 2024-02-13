package com.example.surahyaseen.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.R
import com.example.surahyaseen.adapters.SupplicationInnerAdp
import com.example.surahyaseen.databinding.FragmentSupplicationInnerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SupplicationInner : Fragment() {
    private var _supplicationInnerBinding: FragmentSupplicationInnerBinding? = null

    private val supplicationInnerBinding get() = _supplicationInnerBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _supplicationInnerBinding =
            FragmentSupplicationInnerBinding.inflate(inflater, container, false)
        CoroutineScope(Dispatchers.IO).launch {
            val argument = arguments?.getString("supplicationName", "")

            argument?.let {
                if (it.isNotEmpty()) {
                    supplicationInnerBinding.name.text = argument
                }
            }
        }


        return supplicationInnerBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdp()
        setVP()
    }

    private fun setVP() {
        val adp = SupplicationInnerAdp(1, SupplicationFragment.mutableList)
    }

    private fun setAdp() {
        val adp = SupplicationInnerAdp(0, SupplicationFragment.mutableList)
        supplicationInnerBinding.supplicationInnerRecycler.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        supplicationInnerBinding.supplicationInnerRecycler.adapter = adp
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _supplicationInnerBinding = null
    }
}