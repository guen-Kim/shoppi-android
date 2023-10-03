package org.techtown.shoppi_android.repository.categorydetail

import org.techtown.shoppi_android.model.CategoryDetail
import javax.inject.Inject

class CategoryDetailRepository @Inject constructor(private val remoteDataSource : CategoryDetailRemoteDataSource) {

    suspend fun getCategoryDetail():CategoryDetail {

        return remoteDataSource.getCategoryDetail()
    }
}