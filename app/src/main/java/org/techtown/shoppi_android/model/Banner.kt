package org.techtown.shoppi_android.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl: String,
    val badge: Badge,
    val label: String,
    @SerializedName("product_detail") val product: Product,
)


data class Badge(
    val label: String,
    @SerializedName("background_color") val backGroundColor: String,
)

