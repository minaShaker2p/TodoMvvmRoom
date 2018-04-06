package com.demo.mina.hotels_demo.ui.hotels_list

import android.content.Context
import android.support.annotation.StringRes
import com.demo.mina.hotels_demo.base.BaseView
import com.demo.mina.hotels_demo.base.LoadingView
import com.demo.mina.hotels_demo.data.model.Hotel

/**
 * Created by Mina Alfy on 4/6/2018.
 */
interface HotelsListView:BaseView,LoadingView {
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }
    /* Updates the previous hotels by the specified ones
    * @param hotels the list of posts that will replace existing ones
    */
    fun updateHotels(hotels: List<Hotel.HotelEntity>)

    /**
     * Displays an error in the view
     * @param error the error to display in the view
     */
    fun showError(error: String)

}