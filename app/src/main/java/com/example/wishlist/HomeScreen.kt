package com.example.wishlist

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController, viewModel: WishViewModel) {
    var context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(title = "WishList", {}) },
        floatingActionButton = {
            FloatButton(context = context, navController, 1)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            var listofWishes = viewModel.listOfWishes.collectAsState(initial = listOf())
            LazyColumn(
                modifier = Modifier
                    .wrapContentSize()

            ) {
                items(listofWishes.value) {
                    WishTile(it, {
                        navController.navigate(Screen.AddScreen.route + '/' + it.id)
                    }, {
                        viewModel.deleteWish(it)
                    })
                }
            }
        }

    }

}

@Composable
fun FloatButton(context: Context, navController: NavController, id: Long) {
    FloatingActionButton(
        onClick = {
            Toast.makeText(
                context,
                "",
                Toast.LENGTH_SHORT
            ).show()
            navController.navigate(Screen.AddScreen.route + "/0")

        },
        contentColor = Color.Black,
        containerColor = Color.Blue,
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier.size(72.dp)
    ) {
        Icon(Icons.Filled.Add, null)
    }
}

@Composable
fun WishTile(wish: Wish, onClick: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = wish.heading,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(0.9f)
                )
                IconButton(
                    onClick = { onDelete() },
                    modifier = Modifier
                        .weight(0.1f)
                ) {
                    Icon(Icons.Filled.Delete, "", modifier = Modifier.width(32.dp))
                }
            }
            Text(text = wish.desc)
        }

    }
}