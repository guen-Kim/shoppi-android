package org.techtown.shoppi_android.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techtown.shoppi_android.model.Category
import org.techtown.shoppi_android.repository.CategoryRepository

class CategoryViewModel(private val categoryRepository: CategoryRepository): ViewModel() {

    private val _items = MutableLiveData<List<Category>>()
    val items: LiveData<List<Category>> = _items


    init{
        loadCategory()
    }


    private fun loadCategory() {
        // TODO repository 에 데이터 요청
        viewModelScope.launch {


            val categories = categoryRepository.getCategories()
            _items.value = categories
        }
    }
}