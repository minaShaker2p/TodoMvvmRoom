package com.demo.mina.hotels_demo.base

import android.content.Context

/**
 * Created by Mina Alfy on 4/6/2018.
 */
interface LoadingView {

    fun showLoading() // which will display a ProgressBar
    fun hideLoading()// which will hide a ProgressBar
}