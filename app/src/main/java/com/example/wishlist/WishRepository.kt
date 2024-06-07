package com.example.wishlist

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {
    suspend fun addWish(wish: Wish) {
        wishDao.insert(wish)
    }

    suspend fun updateWish(wish: Wish) {
        wishDao.update(wish)
    }

    fun getAWish(id: Long): Flow<Wish> {
        return wishDao.getAWish(id)
    }

    fun getAllWishes(): Flow<List<Wish>> {
        return wishDao.getAllWishes()
    }

    suspend fun deleteWish(wish: Wish) {
        wishDao.delete(wish)
    }
}