package org.techtown.shoppi_android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.techtown.shoppi_android.AssetsLoader
import org.techtown.shoppi_android.model.CategoryDetail
import org.techtown.shoppi_android.network.ApiClient
import org.techtown.shoppi_android.repository.category.CategoryRemoteDataSource
import org.techtown.shoppi_android.repository.category.CategoryRepository
import org.techtown.shoppi_android.repository.categorydetail.CategoryDetailRemoteDataSource
import org.techtown.shoppi_android.repository.categorydetail.CategoryDetailRepository
import org.techtown.shoppi_android.repository.categorydetail.CategoryDetailViewModel
import org.techtown.shoppi_android.repository.home.HomeAssetDataSource
import org.techtown.shoppi_android.repository.home.HomeRepository
import org.techtown.shoppi_android.ui.category.CategoryViewModel
import org.techtown.shoppi_android.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val repository = HomeRepository(HomeAssetDataSource(AssetsLoader(context)))
            HomeViewModel(repository) as T // 종속 항목 주입된 ViewModel 반환
        }else if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
            CategoryViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CategoryDetailViewModel::class.java)) {
            val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(ApiClient.create()))
            CategoryDetailViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}