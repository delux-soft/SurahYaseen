package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments.SurahImageFragment
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.SurahModel

class SurahAdp(fragment: Fragment, private val list: List<SurahModel>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return list.size
    }


    override fun createFragment(position: Int): Fragment {
        return SurahImageFragment(list[position].image)
    }


}