package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val images = listOf(
            R.drawable.flat11,
            R.drawable.flat12,
            R.drawable.flat13,
            R.drawable.flat14,
            R.drawable.flat15,
            R.drawable.flat17,
            R.drawable.flat18,
            R.drawable.flat19,
        )

        val adapter = viewPagerAdapter(images)
        vpImages.adapter = adapter

        TabLayoutMediator(tlPager, vpImages){tab, position ->
            tab.text = "${position+1}."
        }.attach()

        tlPager.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPagerActivity, "selected tab ${tab?.text}", Toast.LENGTH_LONG).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

//        vpImages.orientation = ViewPager2.ORIENTATION_VERTICAL
//
//        vpImages.beginFakeDrag()
//        vpImages.fakeDragBy(-10f)
//        vpImages.endFakeDrag()
    }
}