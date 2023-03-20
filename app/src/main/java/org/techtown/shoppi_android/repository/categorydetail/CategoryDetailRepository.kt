package org.techtown.shoppi_android.repository.categorydetail

import org.techtown.shoppi_android.model.CategoryDetail

class CategoryDetailRepository(private val remoteDataSource : CategoryDetailRemoteDataSource) {

    suspend fun getCategoryDetail():CategoryDetail {

        return remoteDataSource.getCategoryDetail()
    }
}