package org.techtown.shoppi_android.ui.productdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import org.techtown.shoppi_android.model.Product
import org.techtown.shoppi_android.repository.cart.CartRepository
import org.techtown.shoppi_android.repository.productdetail.ProductDetailRepository
import org.techtown.shoppi_android.ui.common.Event
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productDetailRepository: ProductDetailRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    private var _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product

    // 클릭 이벤트
    private val _addCartEvent = MutableLiveData<Event<Unit>>() // Unit: 버튼 클릭 시 UI에 전달할 데이터 없음
    val addCartEvent:LiveData<Event<Unit>> = _addCartEvent



    fun loadProductData(productId: String) {
        viewModelScope.launch {
            _product.value = productDetailRepository.getProductDetailData(productId)
        }
    }

    fun addCart(product: Product) {
        viewModelScope.launch { // 코루틴 실행
            Log.d("호출", "addCart")
            cartRepository.addCartItem(product)
            _addCartEvent.value = Event(Unit)
        }

    }
}