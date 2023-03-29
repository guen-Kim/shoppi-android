package org.techtown.shoppi_android.repository.cart

import org.techtown.shoppi_android.model.CartItem

interface CartItemDataSource {

    suspend fun addCartItem(cartItem: CartItem)

    suspend fun getCartItems(): List<CartItem>
}