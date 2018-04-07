package com.demo.mina.hotels_demo.ui.hotel_details

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.demo.mina.hotels_demo.R
import com.demo.mina.hotels_demo.data.model.Hotel
import com.demo.mina.hotels_demo.databinding.ActivityHotelDetailsBinding
import com.demo.mina.hotels_demo.utils.EXTRA_HOTEL
import com.demo.mina.hotels_demo.utils.EXTRA_IMAGE
import kotlinx.android.synthetic.main.activity_hotel_details.*

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
    }

    fun navigateToFullScreen(imageUrl: String) {
        val startImageFullScreenPreview: Intent = Intent(this, ImagePreviewFullScreenActivity::class.java)
        startImageFullScreenPreview.putExtra(EXTRA_IMAGE, imageUrl)
        startActivity(startImageFullScreenPreview)
    }
}
