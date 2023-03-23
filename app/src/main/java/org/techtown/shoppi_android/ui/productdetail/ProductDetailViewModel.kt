package org.techtown.shoppi_android.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techtown.shoppi_android.model.Product
import org.techtown.shoppi_android.repository.productdetail.ProductDetailRepository

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository
) : ViewModel() {

    private var _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product


    fun loadProductData(productId: String) {
        viewModelScope.launch {
            _product.value = productDetailRepository.getProductDetailData(productId)
        }
    }
}