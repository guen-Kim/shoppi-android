package org.techtown.shoppi_android.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.techtown.shoppi_android.database.AppDatabase
import org.techtown.shoppi_android.database.CartItemDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideCartItemDao(db : AppDatabase): CartItemDao
    = db.cartItemDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase
    = Room.databaseBuilder(context, AppDatabase::class.java, "shoppi-local").build()

}