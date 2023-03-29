package org.techtown.shoppi_android.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/***
 * item_cart_section_header, item_cart_section 에서 binding 될  공통 CartProduct Model
 * */


sealed class CartProduct

data class CartHeader(
    val brandName: String
) : CartProduct()

@Entity(
    tableName = "cart_item"
)
data class CartItem(
    @PrimaryKey @ColumnInfo(name = "product_id") val productId: String,
    val label: String,
    val price: Int,
    @ColumnInfo(name = "brand_name")val brandName: String,
    @ColumnInfo(name = "thumbnail_image_url") val thumbnailImageUrl: String,
    val type: String,
    val amount: Int
) : CartProduct()