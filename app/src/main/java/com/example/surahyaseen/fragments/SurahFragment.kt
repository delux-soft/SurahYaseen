package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.surahyaseen.adapters.SurahAdp
import com.example.surahyaseen.databinding.FragmentSurahBinding
import com.example.surahyaseen.model.SurahModel
import com.example.surahyaseen.repo.SurahRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SurahFragment : Fragment() {
    private var _surahBinding: FragmentSurahBinding? = null
    private val surahBinding get() = _surahBinding!!

    private val list = mutableListOf<SurahModel>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _surahBinding = FragmentSurahBinding.inflate(inflater, container, false)


        coroutineScope.launch {
            val argument = arguments?.getString("surahName", "")
            argument?.let {
                if (it.isNotEmpty()) {
                    when (it) {
                        HomeFragment.rehman -> {
                            list.addAll(SurahRepo.getSurahRehman())
                        }

                        HomeFragment.yaseen -> {
                            list.addAll(SurahRepo.getSurahYaseen())
                        }
                    }
                }
            }
        }
        return surahBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdp()
    }

    private fun setAdp() {
        val adp = SurahAdp(requireContext(), list)
        surahBinding.surahRecycler.adapter = adp
    }


}