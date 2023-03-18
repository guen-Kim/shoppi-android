package org.techtown.shoppi_android.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techtown.shoppi_android.model.Category
import org.techtown.shoppi_android.repository.category.CategoryRepository

class CategoryViewModel(private val categoryRepository: CategoryRepository): ViewModel() {

    private val _items = MutableLiveData<List<Category>>()
    val items: LiveData<List<Category>> = _items

    //category item state
    private val _openCatetoryEvent = MutableLiveData<Category>()
    val openCatetoryEvent: LiveData<Category> = _openCatetoryEvent


    init{
        loadCategory()
    }

    fun openCategoryDetail(category: Category) {
        Log.d("MVVM클릭이동이벤트처리", "CategoryViewModel.openCategoryDetail(Category)")
        _openCatetoryEvent.value = category
        Log.d("MVVM클릭이동이벤트처리",  "전달된:"+ _openCatetoryEvent.value )
    }




    private fun loadCategory() {
        // TODO repository 에 데이터 요청
        viewModelScope.launch {


            val categories = categoryRepository.getCategories()
            _items.value = categories
        }
    }
}