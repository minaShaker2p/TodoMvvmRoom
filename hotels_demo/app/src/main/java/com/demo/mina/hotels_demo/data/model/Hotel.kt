package com.demo.mina.hotels_demo.data.model

import java.io.Serializable

/**
 * Created by Mina Alfy on 4/6/2018.
 */
/**
 * Class which provides a model for post
 * @constructor Sets all properties of the post
 */
data class Hotel(val hotel: List<HotelEntity>) {
    inner class HotelEntity(val hotelId: Int, val location: Location, val image: List<Image>, val summary: Summary) :Serializable{
        inner class Image(val url: String):Serializable
        inner class Location(val address: String, val latitude: Double, val longitude: Double):Serializable
        inner class Summary(val highRate: Double, val hotelName: String, val lowRate: Double):Serializable
    }
}


