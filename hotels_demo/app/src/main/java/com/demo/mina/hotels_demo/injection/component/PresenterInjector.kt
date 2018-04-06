package com.demo.mina.hotels_demo.injection.component

import com.demo.mina.hotels_demo.base.BaseView
import com.demo.mina.hotels_demo.injection.module.ContextModule
import com.demo.mina.hotels_demo.injection.module.NetworkModule
import com.demo.mina.hotels_demo.ui.hotels_list.HotelListPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Mina Alfy on 4/6/2018.
 */
/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param postPresenter PostPresenter in which to inject the dependencies
     */
    fun inject(hotelListPresenter: HotelListPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}