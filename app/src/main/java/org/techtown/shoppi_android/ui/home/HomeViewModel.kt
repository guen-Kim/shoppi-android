package org.techtown.shoppi_android.ui.home


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.techtown.shoppi_android.model.Banner
import org.techtown.shoppi_android.model.Product
import org.techtown.shoppi_android.model.Promotion
import org.techtown.shoppi_android.model.Title
import org.techtown.shoppi_android.repository.home.HomeRepository
import org.techtown.shoppi_android.ui.common.Event

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {


    // 상단 ui
    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title //데이터 참조
    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanner: LiveData<List<Banner>> = _topBanners

    // 하단 ui
    private val _promotions = MutableLiveData<Promotion>()
    val promotions: LiveData<Promotion> = _promotions



    //top Banner item state
    private val _openProductEvent = MutableLiveData<Event<String>>()
    val openProductEvent: LiveData<Event<String>> = _openProductEvent



    init {
        loadHomeData()
    }

    fun loadHomeData() {
        //TODO Data Layer - Repository 에 요청
        val homeData = homeRepository.getHomeData()
        homeData?.let { homeData ->
            _title.value = homeData.title
            _topBanners.value = homeData.topBanners
            _promotions.value = homeData.promotions
        }

    }

    fun openProductDetail(productId: String) {
        Log.d("click", "HomeViewModel.openProductDetail")
        _openProductEvent.value = Event(productId)
    }

}