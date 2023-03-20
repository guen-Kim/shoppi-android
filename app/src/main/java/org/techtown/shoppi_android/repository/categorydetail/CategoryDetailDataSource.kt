package org.techtown.shoppi_android.repository.categorydetail

import org.techtown.shoppi_android.model.CategoryDetail

interface CategoryDetailDataSource {


    suspend fun getCategoryDetail(): CategoryDetail


}