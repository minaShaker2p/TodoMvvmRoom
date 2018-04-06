package com.demo.mina.hotels_demo.ui.hotels_list

import com.demo.mina.hotels_demo.R
import com.demo.mina.hotels_demo.base.BasePresenter
import com.demo.mina.hotels_demo.data.ApiServiceEndpoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Mina Alfy on 4/6/2018.
 */
/**
 * The Presenter that will present the Post view.
 * @param postView the Post view to be presented by the presenter
 * @property postApi the API interface implementation
 * @property subscription the subscription to the API call
 */
class HotelListPresenter(hotelListView: HotelsListView) : BasePresenter<HotelsListView>(hotelListView) {
    @Inject
    lateinit var serviceApi: ApiServiceEndpoint

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadPosts()
    }

    /**
     * Loads the posts from the API and presents them in the view when retrieved, or showss error if
     * any.
     */
    fun loadPosts() {
        view.showLoading()
        subscription = serviceApi
                .getHotels()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { hotelList -> view.updateHotels(hotelList.hotel) },
                        { view.showError(R.string.unknown_error) }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}