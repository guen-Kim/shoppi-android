package org.techtown.shoppi_android.repository

import org.techtown.shoppi_android.model.HomeData

interface HomeDataSource {


    fun getHomeData(): HomeData?

}