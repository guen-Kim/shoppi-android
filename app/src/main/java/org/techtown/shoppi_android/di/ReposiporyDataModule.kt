package org.techtown.shoppi_android.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import org.techtown.shoppi_android.repository.cart.CartItemDataSource
import org.techtown.shoppi_android.repository.cart.CartItemLocalDataSource
import org.techtown.shoppi_android.repository.category.CategoryDataSource
import org.techtown.shoppi_android.repository.category.CategoryRemoteDataSource
import org.techtown.shoppi_android.repository.categorydetail.CategoryDetailDataSource
import org.techtown.shoppi_android.repository.categorydetail.CategoryDetailRemoteDataSource
import org.techtown.shoppi_android.repository.home.HomeAssetDataSource
import org.techtown.shoppi_android.repository.home.HomeDataSource
import org.techtown.shoppi_android.repository.productdetail.ProductDetailDataSource
import org.techtown.shoppi_android.repository.productdetail.ProductDetailRemoteDataSource
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class ReposiporyDataModule {
    @Binds
    @Singleton
    abstract fun bindCartItemLocalData(impl: CartItemLocalDataSource) : CartItemDataSource

    @Binds
    @Singleton
    abstract fun bindCategoryRemoteData(impl: CategoryRemoteDataSource) : CategoryDataSource


    @Binds
    @Singleton
    abstract fun bindProductDetailData(impl: ProductDetailRemoteDataSource) : ProductDetailDataSource

    @Binds
    @Singleton
    abstract fun bindHomeAssetsData(impl: HomeAssetDataSource) : HomeDataSource


    @Binds
    @Singleton
    abstract fun bindCategoryDetailRemoteData(impl: CategoryDetailRemoteDataSource) : CategoryDetailDataSource


}