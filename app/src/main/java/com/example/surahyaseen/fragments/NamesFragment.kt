package com.example.surahyaseen.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.R
import com.example.surahyaseen.activities.ID
import com.example.surahyaseen.adapters.BottomNumberAdp
import com.example.surahyaseen.adapters.NameAdp
import com.example.surahyaseen.databinding.FragmentNamesBinding
import com.example.surahyaseen.model.NamesModel
import com.example.surahyaseen.utils.Extension.addCarouselEffect
import com.example.surahyaseen.viewModel.MainVM
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.HeroCarouselStrategy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "NamesFragmentXX"

class NamesFragment : Fragment() {
    private var _nameBinding: FragmentNamesBinding? = null
    private val nameBinding get() = _nameBinding!!

    private val mainVM by viewModels<MainVM<NamesModel>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private var adp: BottomNumberAdp? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _nameBinding = FragmentNamesBinding.inflate(inflater, container, false)


        coroutineScope.launch {
            val argument = arguments?.getString("names", "")
            Log.d(TAG, "onCreateView: $argument")
            argument?.let {
                if (it.isNotEmpty()) {
                    when (it) {

                        HomeFragment.allahName -> {
                            nameBinding.name.setText(R.string.allah_names)
                            mainVM.getAllahNames()
                        }

                        HomeFragment.prophetName -> {
                            nameBinding.name.setText(R.string.prophet_names)
                            mainVM.getMuhammadName()
                        }
                    }
                }
            }
        }

        return nameBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()
        nameBinding.namesHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }
        nameBinding.namesHeader.settings.setOnClickListener {
            findNavController().navigate(ID.namesToSetting)
        }
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(it: List<NamesModel>) {
        val adapter = NameAdp()
        nameBinding.namesRecycler.addCarouselEffect()
        nameBinding.namesRecycler.adapter = adapter
        adapter.submitList(it)
        setBottomRecycler(it.size)
    }

    private fun setBottomRecycler(size: Int) {
        val list = mutableListOf<Int>()
        for (i in 1..size) {
            list.add(i)
        }

        adp = BottomNumberAdp(list) {
            smoothScroll(it)
        }

        adp?.let { nameBinding.numberRecycler.initialize(it) }


    }

    private fun smoothScroll(it: Int) {
        nameBinding.numberRecycler.smoothScrollToPosition(it)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _nameBinding = null
    }


}