package com.example.surahyaseen.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.surahyaseen.fragments.SurahImageFragment
import com.example.surahyaseen.model.SurahModel

class SurahAdp(fragment: Fragment, private val list: List<SurahModel>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return list.size
    }


    override fun createFragment(position: Int): Fragment {
        return SurahImageFragment(list[position].image)
    }


}