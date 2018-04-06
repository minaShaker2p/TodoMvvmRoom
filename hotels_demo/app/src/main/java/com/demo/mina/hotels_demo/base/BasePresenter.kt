package com.demo.mina.hotels_demo.base

import com.demo.mina.hotels_demo.injection.component.DaggerPresenterInjector
import com.demo.mina.hotels_demo.injection.component.PresenterInjector
import com.demo.mina.hotels_demo.injection.module.ContextModule
import com.demo.mina.hotels_demo.injection.module.NetworkModule
import com.demo.mina.hotels_demo.ui.hotels_list.HotelListPresenter

/**
 * Created by Mina Alfy on 4/6/2018.
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated() {}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed() {}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is HotelListPresenter -> injector.inject(this)
        }
    }
}