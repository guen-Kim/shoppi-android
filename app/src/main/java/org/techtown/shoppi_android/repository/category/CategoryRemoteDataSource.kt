package org.techtown.shoppi_android.repository.category

import org.techtown.shoppi_android.model.Category
import org.techtown.shoppi_android.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}