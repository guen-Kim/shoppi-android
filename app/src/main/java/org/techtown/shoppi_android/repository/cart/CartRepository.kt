package org.techtown.shoppi_android.repository.cart

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.techtown.shoppi_android.di.IoDispatcher
import org.techtown.shoppi_android.model.CartItem
import org.techtown.shoppi_android.model.Product
import javax.inject.Inject

class CartRepository @Inject constructor(
    private val localDataSource: CartItemLocalDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO // IO 스레드, 데이터를 요청하는 부분
) {

    suspend fun addCartItem(product: Product) { // product detail 화면 버튼 클릭시 호출
        Log.d("addCartItem:","호출")

        withContext(ioDispatcher) {
            val cartItem =CartItem(
                productId = product.productId,
                label = product.label,
                price = product.price,
                brandName = product.brandName ?: "", // null 타입 대응
                thumbnailImageUrl = product.thumbnailImageUrl ?:"",
                type = product.type ?:"",
                amount = 1
            )
            localDataSource.addCartItem(cartItem)
        }
    }

    suspend fun getCartItem(): List<CartItem> { // CartView 에서 담긴 item 출력시 사용
        return withContext(ioDispatcher) {
            Log.d("getCartItem:","호출")
            localDataSource.getCartItems()
        }
    }
}