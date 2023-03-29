package org.techtown.shoppi_android.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.techtown.shoppi_android.model.CartItem

@Dao
interface CartItemDao {
    //이미 추가된 item이라면 데이터만 수정
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cartItem: CartItem)

    @Query("SELECT * FROM cart_item")
    suspend fun load(): List<CartItem>


}