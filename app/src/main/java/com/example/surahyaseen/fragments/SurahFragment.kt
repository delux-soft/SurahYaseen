package com.example.surahyaseen.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.surahyaseen.R
import com.example.surahyaseen.activities.ID
import com.example.surahyaseen.adapters.SurahAdp
import com.example.surahyaseen.databinding.FragmentSurahBinding
import com.example.surahyaseen.model.SurahModel
import com.example.surahyaseen.viewModel.MainVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "SurahFragmentXX"

class SurahFragment : Fragment() {
    private var _surahBinding: FragmentSurahBinding? = null
    private val surahBinding get() = _surahBinding!!

    private val mainVM by viewModels<MainVM<SurahModel>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _surahBinding = FragmentSurahBinding.inflate(inflater, container, false)


        coroutineScope.launch {
            val argument = arguments?.getString("surahName", "")
            Log.d(TAG, "onCreateView: $argument")
            argument?.let {
                if (it.isNotEmpty()) {
                    when (it) {

                        HomeFragment.yaseen -> {
                            surahBinding.headInner.setImageResource(R.drawable.yaseen)
                            mainVM.getYaseenList()
                        }

                        HomeFragment.rehman -> {
                            surahBinding.headInner.setImageResource(R.drawable.rehman)
                            mainVM.getRehmanList()
                        }
                    }
                }
            }
        }
        return surahBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()

        surahBinding.surahHeader.settings.setOnClickListener {
            findNavController().navigate(ID.surahToSetting)
        }
        surahBinding.surahHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun bindObserver() {
        mainVM.liveData.observe(viewLifecycleOwner) {
            setAdp(it)
        }
    }

    private fun setAdp(list: List<SurahModel>) {
        val adp = SurahAdp(this, list)
        surahBinding.surahVP.adapter = adp
        surahBinding.surahVP.setCurrentItem(list.size - 1, true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _surahBinding = null
    }
}