package org.techtown.shoppi_android.repository.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techtown.shoppi_android.model.Promotions
import org.techtown.shoppi_android.model.TopSelling

class CategoryDetailViewModel(private val repository: CategoryDetailRepository): ViewModel() {


    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling: LiveData<TopSelling> = _topSelling

    private val _promotions = MutableLiveData<Promotions>()
    val promotions: LiveData<Promotions> = _promotions

    init{
        loadCategoryDetail()
    }

    private fun loadCategoryDetail() {
        viewModelScope.launch {
            val categoryDetail = repository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotions.value = categoryDetail.promotions

        }


    }


}