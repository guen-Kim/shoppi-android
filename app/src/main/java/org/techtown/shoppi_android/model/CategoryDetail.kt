package org.techtown.shoppi_android.model

import com.google.gson.annotations.SerializedName

data class CategoryDetail(
    @SerializedName("top_selling") val topSelling: TopSelling,
    val promotions: Promotions
)


data class TopSelling(
    val title: Title,
    val categories :List<Category>,
)

data class Promotions(
    val title: Title,
    val items: List<Product>
)


data class Text(
    val text: String
)


