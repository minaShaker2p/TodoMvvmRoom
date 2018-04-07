package com.demo.mina.hotels_demo.ui.hotels_list

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.demo.mina.hotels_demo.R
import com.demo.mina.hotels_demo.data.model.Hotel
import com.demo.mina.hotels_demo.databinding.ItemHotelBinding
import com.demo.mina.hotels_demo.ui.hotel_details.HotelDetailsActivity
import com.demo.mina.hotels_demo.utils.EXTRA_HOTEL

/**
 * Created by Mina Alfy on 4/6/2018.
 */
class HotelsAdapter(var context: Context) : RecyclerView.Adapter<HotelsAdapter.HotelViewHolder>() {
    /**
     * The list of hotels of the adapter
     */
    private var hotels: List<Hotel.HotelEntity> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HotelViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding: ItemHotelBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_hotel, parent, false)
        return HotelViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hotels.size
    }

    override fun onBindViewHolder(holder: HotelViewHolder?, position: Int) {
        holder?.bind(hotels[position])
        holder?.binding?.root?.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(view: View) {
                        navigateToHotelDEtails(hotels[position])
                    }
                }
        )
    }

    private fun navigateToHotelDEtails(hotelEntity: Hotel.HotelEntity) {
        var startDetails = Intent(context, HotelDetailsActivity::class.java)
        startDetails.putExtra(EXTRA_HOTEL, hotelEntity)
        context.startActivity(startDetails)
    }

    /**
     * Updates the list of posts of the adapter
     * @param posts the new list of posts of the adapter
     */
    fun updatePosts(hotels: List<Hotel.HotelEntity>) {
        this.hotels = hotels
        notifyDataSetChanged()
    }


    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for Post item
     */
    public class HotelViewHolder(val binding: ItemHotelBinding) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Binds a post into the view
         */
        fun bind(hotel: Hotel.HotelEntity) {
            binding.hotel = hotel
            binding.executePendingBindings()
        }
    }

    interface HotelsInteractor {
        fun OnHotelItemCLicked(hotel: Hotel.HotelEntity)
    }
}