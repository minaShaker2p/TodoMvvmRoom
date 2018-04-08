package com.demo.mina.hotels_demo.ui.hotel_details

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.demo.mina.hotels_demo.R
import com.demo.mina.hotels_demo.data.model.Hotel
import com.demo.mina.hotels_demo.databinding.ActivityHotelDetailsBinding
import com.demo.mina.hotels_demo.utils.EXTRA_HOTEL
import com.demo.mina.hotels_demo.utils.EXTRA_IMAGE
import kotlinx.android.synthetic.main.activity_hotel_details.*
import kotlinx.android.synthetic.main.toolbar.*


class HotelDetailsActivity : AppCompatActivity() {
    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityHotelDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hotel_details)
        val extra: Bundle = intent.extras
        val hotel: Hotel.HotelEntity = extra.getSerializable(EXTRA_HOTEL) as Hotel.HotelEntity
        binding.hotelDetails = hotel
        image_hotel_details.setOnClickListener({ navigateToFullScreen(hotel.image.get(0).url) })
        initUI()
    }
    private fun initUI() {
        setSupportActionBar(toolbar_hotels_details_activity as Toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)

        }
        toolbar_title.setText(R.string.toolbar_hotels_details_title)
        tv_high_rate_price.setPaintFlags(tv_high_rate_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
    }
    fun navigateToFullScreen(imageUrl: String) {
        val startImageFullScreenPreview = Intent(this, ImagePreviewFullScreenActivity::class.java)
        startImageFullScreenPreview.putExtra(EXTRA_IMAGE, imageUrl)
        startActivity(startImageFullScreenPreview)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
