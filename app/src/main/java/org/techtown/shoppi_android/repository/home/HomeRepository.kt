package org.techtown.shoppi_android.repository.home

import org.techtown.shoppi_android.model.HomeData

class HomeRepository(private val assetDataSource: HomeAssetDataSource) {

     fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }

}