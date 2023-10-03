package org.techtown.shoppi_android.repository.home

import org.techtown.shoppi_android.model.HomeData
import javax.inject.Inject

class HomeRepository @Inject constructor(private val assetDataSource: HomeAssetDataSource) {

     fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }

}