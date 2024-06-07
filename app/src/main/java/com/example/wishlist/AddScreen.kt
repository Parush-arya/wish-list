package com.example.wishlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditScreen(id: Long, navController: NavController, viewModel: WishViewModel) {
    if (id != 0L) {
        val wish = viewModel.getWishById(id).collectAsState(initial = Wish("", "", 0))
        viewModel.titleState = wish.value.heading
        viewModel.descriptionState = wish.value.desc
    } else {
        viewModel.titleState = ""
        viewModel.descriptionState = ""
    }
    Scaffold(
        topBar = {
            TopBar(title = if (id != 0L) "Add Wish" else "Edit Wish", {
                navController.navigateUp()
            })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(paddingValues = it)
                .fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            TextField(
                value = viewModel.titleState,
                onValueChange = {
                    viewModel.onTitleChanged(it)
                },
                Modifier.background(shape = RoundedCornerShape(32.dp), color = Color.White),
                shape = RoundedCornerShape(32.dp),
                colors = TextFieldDefaults.textFieldColors(
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewModel.descriptionState, onValueChange = {
                    viewModel.onDescriptionChanged(it)
                },
                Modifier.background(shape = RoundedCornerShape(32.dp), color = Color.Gray),
                shape = RoundedCornerShape(32.dp),
                colors = TextFieldDefaults.textFieldColors(
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (viewModel.titleState.isNotBlank() && viewModel.descriptionState.isNotBlank()) {
                    if (id == 0L) {
                        viewModel.addWish(
                            Wish(
                                heading = viewModel.titleState,
                                desc = viewModel.descriptionState
                            )
                        )
                    } else {
                        viewModel.updateWish(
                            Wish(
                                viewModel.titleState,
                                viewModel.descriptionState,
                                id
                            )
                        )
                    }
                    navController.navigateUp()
                }
            }) {
                Text(text = if (id == 0L) "Add" else "Edit", fontSize = 24.sp)
            }

        }
    }
}

