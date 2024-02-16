package com.example.surahyaseen.fragments

import android.icu.util.IslamicCalendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.surahyaseen.databinding.FragmentCalenderBinding
import java.util.Calendar


private const val TAG = "CalenderFragmentXX"
class CalenderFragment : Fragment() {
    private var _calenderBinding: FragmentCalenderBinding? = null
    private val calenderBinding get() = _calenderBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _calenderBinding = FragmentCalenderBinding.inflate(inflater, container, false)

        val currentCalender = IslamicCalendar.getInstance()

        val islamicYear: Int = currentCalender.get(IslamicCalendar.YEAR)
        val islamicMonth: Int = currentCalender.get(IslamicCalendar.MONTH)
        val islamicDay: Int = currentCalender.get(IslamicCalendar.DAY_OF_MONTH)


        Log.d(TAG, "onCreateView: $islamicYear $islamicMonth $islamicDay")


        return calenderBinding.root
    }


}