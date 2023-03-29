package org.techtown.shoppi_android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.techtown.shoppi_android.model.CartItem

@Database(entities = [CartItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun cartItemDao(): CartItemDao

}