package org.techtown.shoppi_android.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.techtown.shoppi_android.Banner
import org.techtown.shoppi_android.Title

class HomeViewModel: ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title


    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanner: LiveData<List<Banner>> = _topBanners




    fun  loadHomeData(){
        //TODO Data Layer - Repository 에 요청

   }

}