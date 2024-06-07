package com.example.wishlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.wishlist.ui.theme.WishListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var viewModel: WishViewModel = WishViewModel()
            WishListTheme {
                Navigation(viewModel)
            }
        }
    }
}

var list = listOf<Wish>(
    Wish("first one", "description", 0),
    Wish("first one", "description", 0),
    Wish("first one", "description", 1),
    Wish("first one", "description", 1)


)

