package com.demo.mina.hotels_demo.ui.hotel_details

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.demo.mina.hotels_demo.R
import com.demo.mina.hotels_demo.databinding.ActivityImagePreviewFullScreenBinding
import com.demo.mina.hotels_demo.utils.EXTRA_IMAGE

class ImagePreviewFullScreenActivity : AppCompatActivity() {
    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityImagePreviewFullScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_preview_full_screen)
        val extra: Bundle = intent.extras
        val imageUrl: String= extra.getString(EXTRA_IMAGE)
        binding.imageUrl=imageUrl


    }
}
