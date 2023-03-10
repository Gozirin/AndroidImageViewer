package com.gozirin.sample.features.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gozirin.sample.R
import com.gozirin.sample.features.demo.grid.PostersGridDemoActivity
import com.gozirin.sample.features.demo.rotation.RotationDemoActivity
import com.gozirin.sample.features.demo.scroll.ScrollingImagesDemoActivity
import com.gozirin.sample.features.demo.styled.StylingDemoActivity
import com.gozirin.sample.features.main.adapter.MainActivityPagerAdapter
import com.gozirin.sample.features.main.adapter.MainActivityPagerAdapter.Companion.ID_IMAGES_GRID
import com.gozirin.sample.features.main.adapter.MainActivityPagerAdapter.Companion.ID_ROTATION
import com.gozirin.sample.features.main.adapter.MainActivityPagerAdapter.Companion.ID_SCROLL
import com.gozirin.sample.features.main.adapter.MainActivityPagerAdapter.Companion.ID_STYLING
import com.gozirin.sample.features.main.card.DemoCardFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    DemoCardFragment.OnCardActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainCardsViewPager.apply {
            adapter = MainActivityPagerAdapter(this@MainActivity, supportFragmentManager)
            pageMargin = resources.getDimension(R.dimen.card_padding).toInt() / 4
            offscreenPageLimit = 3
        }
        mainCardsPagerIndicator.setViewPager(mainCardsViewPager)
    }

    override fun onCardAction(actionId: Int) {
        when (actionId) {
            ID_IMAGES_GRID -> {
                startActivity(Intent(this, PostersGridDemoActivity::class.java))
            }
            ID_SCROLL -> {
                startActivity(Intent(this, ScrollingImagesDemoActivity::class.java))
            }
            ID_STYLING -> {
                startActivity(Intent(this, StylingDemoActivity::class.java))
            }
            ID_ROTATION -> {
                startActivity(Intent(this, RotationDemoActivity::class.java))
            }
        }
    }
}
