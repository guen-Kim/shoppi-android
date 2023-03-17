package org.techtown.shoppi_android.repository

import org.techtown.shoppi_android.model.Category
import org.techtown.shoppi_android.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSouce {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}