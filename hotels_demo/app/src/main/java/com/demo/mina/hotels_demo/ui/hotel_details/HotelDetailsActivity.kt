package com.demo.mina.hotels_demo.ui.hotel_details

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.demo.mina.hotels_demo.R
import com.demo.mina.hotels_demo.data.model.Hotel
import com.demo.mina.hotels_demo.databinding.ActivityHotelDetailsBinding
import com.demo.mina.hotels_demo.utils.EXTRA_HOTEL

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

    }
}
