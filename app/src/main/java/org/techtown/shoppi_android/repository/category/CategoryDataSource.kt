package org.techtown.shoppi_android.repository.category

import org.techtown.shoppi_android.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>


}