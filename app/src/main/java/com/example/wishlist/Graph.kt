package com.example.wishlist

import android.content.Context
import androidx.room.Room

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.getWishDao())
    }

    fun provide(context: Context) {
        database =
            Room.databaseBuilder(context = context, WishDatabase::class.java, "WishList.DB").build()
    }

}