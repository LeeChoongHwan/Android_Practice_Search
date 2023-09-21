package com.example.android_practice_search.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice_search.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = MainViewPagerAdapter(this@MainActivity)
        initView()
    }

    private fun initView() {
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tablayout, binding.viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()
    }
}