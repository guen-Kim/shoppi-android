package org.techtown.shoppi_android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.techtown.shoppi_android.AssetsLoader
import org.techtown.shoppi_android.network.ApiClient
import org.techtown.shoppi_android.network.ServiceLocator
import org.techtown.shoppi_android.repository.category.CategoryRemoteDataSource
import org.techtown.shoppi_android.repository.category.CategoryRepository
import org.techtown.shoppi_android.repository.categorydetail.CategoryDetailRemoteDataSource
import org.techtown.shoppi_android.repository.categorydetail.CategoryDetailRepository
import org.techtown.shoppi_android.repository.categorydetail.CategoryDetailViewModel
import org.techtown.shoppi_android.repository.home.HomeAssetDataSource
import org.techtown.shoppi_android.repository.home.HomeRepository
import org.techtown.shoppi_android.repository.productdetail.ProductDetailRemoteDataSource
import org.techtown.shoppi_android.repository.productdetail.ProductDetailRepository
import org.techtown.shoppi_android.ui.category.CategoryViewModel
import org.techtown.shoppi_android.ui.home.HomeViewModel
import org.techtown.shoppi_android.ui.productdetail.ProductDetailViewModel
import java.lang.IllegalArgumentException

//종속 항목 주입된 ViewModel 생성
class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            // 안드로이드 asset 에서 데이터 로드
            val repository = HomeRepository(HomeAssetDataSource(AssetsLoader(context)))
            HomeViewModel(repository) as T // 종속 항목 주입된 ViewModel 반환
        }else if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            val repository = CategoryRepository(CategoryRemoteDataSource(ServiceLocator.provideApiClient()))
            CategoryViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CategoryDetailViewModel::class.java)) {
            val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(ServiceLocator.provideApiClient()))
            CategoryDetailViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {

            val repository = ProductDetailRepository(ProductDetailRemoteDataSource(ServiceLocator.provideApiClient()))
            ProductDetailViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}