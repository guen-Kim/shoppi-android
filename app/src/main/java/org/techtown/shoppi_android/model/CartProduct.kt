package org.techtown.shoppi_android.model


/***
 * item_cart_section_header, item_cart_section 에서 binding 될  공통 CartProduct Model
 * */


sealed class CartProduct

data class CartHeader(
    val brandName: String
) : CartProduct()

data class CartItem(
    val productId: String,
    val label: String,
    val price: Int,
    val brandName: String,
    val thumbnailImageUrl: String,
    val type: String,
    val amount: Int
) : CartProduct()