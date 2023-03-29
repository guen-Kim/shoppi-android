package org.techtown.shoppi_android.repository.cart

import org.techtown.shoppi_android.database.CartItemDao
import org.techtown.shoppi_android.model.CartItem

class CartItemLocalDataSource(
    private val dao: CartItemDao
): CartItemDataSource {

    override suspend fun addCartItem(cartItem: CartItem) {
        dao.insert(cartItem)
    }

    override suspend fun getCartItems(): List<CartItem> {
        return dao.load()
    }

}