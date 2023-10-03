package org.techtown.shoppi_android.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.techtown.shoppi_android.model.CartItem
import org.techtown.shoppi_android.repository.cart.CartRepository
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val cartRepository: CartRepository) : ViewModel() {
    private val _items = MutableLiveData<List<CartItem>>()
    val items: LiveData<List<CartItem>> = _items


    init {
        loadCartItem()
    }


    private fun loadCartItem() {
        viewModelScope.launch {
            _items.value = cartRepository.getCartItem()

        }
    }
}