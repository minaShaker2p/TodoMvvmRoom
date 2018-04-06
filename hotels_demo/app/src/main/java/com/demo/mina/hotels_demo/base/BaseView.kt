package com.demo.mina.hotels_demo.base

import android.content.Context

/**
 * Created by Mina Alfy on 4/6/2018.
 */
interface BaseView {
    /**
     * Returns the Context in which the application is running.
     * @return the Context in which the application is running
     */
    fun getContext(): Context
}