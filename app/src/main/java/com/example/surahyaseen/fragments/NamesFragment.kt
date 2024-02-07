package com.example.surahyaseen.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.surahyaseen.R
import com.example.surahyaseen.databinding.FragmentNamesBinding
import com.example.surahyaseen.viewModel.MainVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "NamesFragmentXX"

class NamesFragment : Fragment() {
    private var _nameBinding: FragmentNamesBinding? = null
    private val nameBinding get() = _nameBinding!!

    private val mainVM by viewModels<MainVM>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
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
                            mainVM.getYaseenList()
                        }

                        HomeFragment.prophetName -> {
                            nameBinding.name.setText(R.string.prophet_names)
                            mainVM.getRehmanList()
                        }
                    }
                }
            }
        }

        return nameBinding.root
    }


}