package org.techtown.shoppi_android.repository.cart

import org.techtown.shoppi_android.database.CartItemDao
import org.techtown.shoppi_android.model.CartItem
import javax.inject.Inject

class CartItemLocalDataSource @Inject constructor(
    private val dao: CartItemDao
): CartItemDataSource {

    override suspend fun addCartItem(cartItem: CartItem) {
        dao.insert(cartItem)
    }

    override suspend fun getCartItems(): List<CartItem> {
        return dao.load()
    }

}