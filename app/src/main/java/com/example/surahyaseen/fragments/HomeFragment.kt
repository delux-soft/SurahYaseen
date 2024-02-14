package com.example.surahyaseen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.surahyaseen.databinding.FragmentHomeBinding
import com.example.surahyaseen.enums.MainMode.HomeMode


interface HomeListener {
    fun onHomeClick(value: HomeMode)

}

class HomeFragment : Fragment() {
    private var _homeBinding: FragmentHomeBinding? = null
    private val homeBinding get() = _homeBinding!!

    private var listener: HomeListener? = null

    fun setHomeListener(listener: HomeListener) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _homeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindListeners()
    }

    private fun bindListeners() {

        homeBinding.apply {

            surahYaseen.setOnClickListener {
                listener?.onHomeClick(HomeMode.YASEEN)
            }

            surahRehman.setOnClickListener {
                listener?.onHomeClick(HomeMode.REHMAN)
            }

            allahNames.setOnClickListener {
                listener?.onHomeClick(HomeMode.ALLAH)
            }

            prophetNames.setOnClickListener {
                listener?.onHomeClick(HomeMode.PROPHET)
            }

            sixQalma.setOnClickListener {
                listener?.onHomeClick(HomeMode.KALMA)
            }

            fourQul.setOnClickListener {
                listener?.onHomeClick(HomeMode.QUL)
            }

            supplications.setOnClickListener {
                listener?.onHomeClick(HomeMode.SUPPLICATION)
            }

            tasbeeh.setOnClickListener {
                listener?.onHomeClick(HomeMode.COUNTER)
            }
            calender.setOnClickListener {
                listener?.onHomeClick(HomeMode.CALENDER)
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _homeBinding = null
    }


    companion object {
        const val yaseen = "Yaseen"
        const val rehman = "Rehman"
        const val allahName = "Allah"
        const val prophetName = "Prophet"
    }


}