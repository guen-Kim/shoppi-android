package org.techtown.shoppi_android.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import org.techtown.shoppi_android.repository.home.HomeAssetDataSource
import org.techtown.shoppi_android.repository.home.HomeDataSource
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeDataModule {
    @Binds
    @Singleton
    abstract fun bindHomeAssetsData(impl: HomeAssetDataSource) : HomeDataSource

}