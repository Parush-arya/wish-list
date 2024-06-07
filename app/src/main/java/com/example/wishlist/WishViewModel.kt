package com.example.wishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(private val wishRepository: WishRepository = Graph.wishRepository) :
    ViewModel() {
    var titleState by mutableStateOf("");
    var descriptionState by mutableStateOf("");

    fun onTitleChanged(str: String) {
        this.titleState = str
    }

    fun onDescriptionChanged(str: String) {
        this.descriptionState = str
    }

    lateinit var listOfWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            listOfWishes = wishRepository.getAllWishes()
        }
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch {
            wishRepository.addWish(wish)
        }
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch {
            wishRepository.updateWish(wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch {
            wishRepository.deleteWish(wish)
        }
    }

    fun getWishById(id: Long): Flow<Wish> {
        return wishRepository.getAWish(id)
    }
}