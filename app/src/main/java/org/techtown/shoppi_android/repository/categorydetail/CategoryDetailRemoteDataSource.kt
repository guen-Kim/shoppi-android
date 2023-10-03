package org.techtown.shoppi_android.repository.categorydetail

import org.techtown.shoppi_android.model.CategoryDetail
import org.techtown.shoppi_android.network.ApiClient
import javax.inject.Inject

class CategoryDetailRemoteDataSource @Inject constructor(private val apiClient: ApiClient) : CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return apiClient.getCategoryDetail()

    }

}