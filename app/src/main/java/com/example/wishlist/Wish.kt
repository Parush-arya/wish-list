package com.example.wishlist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("wishTable")
data class Wish(
    var heading: String,
    var desc: String,
    @PrimaryKey(true)
    var id: Long = 0L
)