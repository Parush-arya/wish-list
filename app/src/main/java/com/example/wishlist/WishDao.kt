package com.example.wishlist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    @Insert
    abstract suspend fun insert(wish: Wish)

    @Update
    abstract suspend fun update(wish: Wish)

    @Delete
    abstract suspend fun delete(wish: Wish)

    @Query("Select * from `wishTable`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Query("Select * from `wishTable` where id=:id")
    abstract fun getAWish(id: Long): Flow<Wish>
}