package com.demo.mina.hotels_demo.ui.hotels_list


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.Toast
import com.demo.mina.hotels_demo.R
import com.demo.mina.hotels_demo.base.BaseActivity
import com.demo.mina.hotels_demo.data.model.Hotel
import com.demo.mina.hotels_demo.databinding.ActivityHotelsListBinding

class HotelsListActivity : BaseActivity<HotelListPresenter>(), HotelsListView {
    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityHotelsListBinding

    /**
     * The adapter for the list of posts
     */
    private val hotelsAdapter = HotelsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_hotels_list)
        binding.adapter = hotelsAdapter
        val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.layoutManager = manager
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    /**
     * method which called by presenter will notify adapter data
     */
    override fun updateHotels(hotels: List<Hotel.HotelEntity>) {
        hotelsAdapter.updatePosts(hotels)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun instantiatePresenter(): HotelListPresenter {
        return HotelListPresenter(this)
    }


}
