package org.techtown.shoppi_android.repository.home

import com.google.gson.Gson
import org.techtown.shoppi_android.AssetsLoader
import org.techtown.shoppi_android.model.HomeData
import javax.inject.Inject

class HomeAssetDataSource @Inject constructor(private val assetsLoader: AssetsLoader) : HomeDataSource {

    private val gson = Gson()

    override fun getHomeData(): HomeData? {
        return assetsLoader.getJsonString("home.json")?.let {
            homeJsonString -> gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}