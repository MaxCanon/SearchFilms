package com.example.searchfilms.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.searchfilms.R
import com.example.searchfilms.databinding.ActivityDetailsBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var tabsMediator: TabLayoutMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val poster = intent.getStringExtra("poster") ?: ""
        val movieId = intent.getStringExtra("id") ?: ""

        binding.viewPager.adapter = DetailsViewPagerAdapter(supportFragmentManager,
            lifecycle, poster, movieId)

        tabsMediator = TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = getString(R.string.poster)
                1 -> tab.text = getString(R.string.details)
            }
        }
        tabsMediator.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        tabsMediator.detach()
    }
}