package org.techtown.shoppi_android

import android.content.Context
import androidx.room.Room
import org.techtown.shoppi_android.database.AppDatabase
import org.techtown.shoppi_android.network.ApiClient
import org.techtown.shoppi_android.repository.cart.CartItemLocalDataSource
import org.techtown.shoppi_android.repository.cart.CartRepository


/**
 *
 * ServiceLocator
 *  재사용 가능 인스턴스
 *  ApiClient, Database
 ***/

object ServiceLocator {

    private var apiClient: ApiClient? = null
    private var database: AppDatabase? = null
    private var cartRepository: CartRepository? = null


    // ApiClient 가 이미 생성되었 섰는지 판단
    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }


    fun provideCartRepository(context: Context): CartRepository {
        return cartRepository ?: kotlin.run {
            val dao = provideDatabase(context.applicationContext).cartItemDao()
            CartRepository(CartItemLocalDataSource(dao)).also {
                cartRepository = it
            }
        }
    }

    private fun provideDatabase(applicationContext: Context): AppDatabase {
        return database ?: kotlin.run {
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "shoppi-local"

            ).build().also {
                database = it
            }

        }
    }


}