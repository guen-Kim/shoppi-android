package org.techtown.shoppi_android.ui.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.techtown.shoppi_android.model.Promotion
import org.techtown.shoppi_android.model.TopSelling
import org.techtown.shoppi_android.repository.categorydetail.CategoryDetailRepository
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(private val repository: CategoryDetailRepository): ViewModel() {


    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling: LiveData<TopSelling> = _topSelling

    private val _promotion = MutableLiveData<Promotion>()
    val promotions: LiveData<Promotion> = _promotion

    init{
        loadCategoryDetail()
    }

    private fun loadCategoryDetail() {
        viewModelScope.launch {
            val categoryDetail = repository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotion.value = categoryDetail.promotion

        }
    }
}