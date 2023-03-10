package org.techtown.shoppi_android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.techtown.shoppi_android.AssetsLoader
import org.techtown.shoppi_android.repository.HomeAssetDataSource
import org.techtown.shoppi_android.repository.HomeRepository
import org.techtown.shoppi_android.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val repository = HomeRepository(HomeAssetDataSource(AssetsLoader(context)))
            return HomeViewModel(repository) as T // 종속 항목 주입된 ViewModel 반환

        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}