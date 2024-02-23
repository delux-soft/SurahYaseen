package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments

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
import androidx.viewpager2.widget.ViewPager2
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.ID
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.string
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.BottomNumberAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.NameAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.NamesModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.Extension.addCarouselEffect
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.viewModel.MainVM
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentNamesBinding
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.NumberModel
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
                            nameBinding.name.setText(string.allah_names)
                            mainVM.getAllahNames()
                        }

                        HomeFragment.prophetName -> {
                            nameBinding.name.setText(string.prophet_names)
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
        bindListener()
        nameBinding.namesHeader.speaker.visibility = View.GONE
        nameBinding.namesHeader.playPause.visibility = View.GONE
    }


    private fun bindListener() {
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
        val list = it.reversed()
        nameBinding.namesVP.addCarouselEffect()
        nameBinding.namesVP.adapter = adapter
        adapter.submitList(list)
        nameBinding.namesVP.setCurrentItem(it.lastIndex, true)
        setBottomRecycler(it.size)

        nameBinding.namesVP.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

                val value = positionOffset.compareTo(0.0)
                if (value == 0) {
                    val index = nameBinding.namesVP.currentItem
                    nameBinding.numberRecycler.smoothScrollToPosition(index)
                    adp?.selectPosition(index)
                }

            }


        })
    }

    private fun setBottomRecycler(size: Int) {
        val list = mutableListOf<NumberModel>()
        for (i in 1..size) {
            list.add(NumberModel(i))
        }
        list.reverse()
        adp = BottomNumberAdp(list)
        nameBinding.numberRecycler.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        nameBinding.numberRecycler.adapter = adp


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _nameBinding = null
    }


}