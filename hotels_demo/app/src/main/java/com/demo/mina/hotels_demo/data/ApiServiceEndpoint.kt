package com.demo.mina.hotels_demo.data

import com.demo.mina.hotels_demo.data.model.Hotel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Mina Alfy on 4/6/2018.
 */
interface ApiServiceEndpoint {
    /**
     * Get the list of the pots from the API
     */
    @GET("hotels_exercise.json")
    fun getHotels(): Observable<List<Hotel>>
}