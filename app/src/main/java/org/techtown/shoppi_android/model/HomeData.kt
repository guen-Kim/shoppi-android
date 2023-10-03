package org.techtown.shoppi_android.model

import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class HomeData (
    val title: Title,
    @SerializedName("top_banners") val topBanners: List<Banner>,
    val promotions: Promotion,
)
