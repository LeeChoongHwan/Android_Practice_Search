package com.example.android_practice_search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val tabs = arrayListOf<MainTabs>(
        MainTabs(SearchFragment(),R.string.tab_search),
        MainTabs(BookmarkFragment(), R.string.tab_bookmark)
    )

    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabs[position].fragment
    }

    fun getTitle(position: Int) : Int {
        return tabs[position].titleRes
    }
}