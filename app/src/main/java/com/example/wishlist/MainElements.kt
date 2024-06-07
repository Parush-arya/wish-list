package com.example.wishlist

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(title: String, onBackClicked: () -> Unit) {
    TopAppBar(
        title = {
            if (title != "WishList")
                IconButton(onClick = onBackClicked) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        "",
                        modifier = Modifier
                            .padding(top = 12.dp)
                    )
                }
            else
                null

            Text(
                text = title,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(top = 12.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            )
        },
        backgroundColor = Color.Blue,
        modifier = Modifier.height(64.dp)
    )
}