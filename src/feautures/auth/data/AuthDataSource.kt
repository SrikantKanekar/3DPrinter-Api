package com.example.feautures.auth.data

import com.example.feautures.wishlist.domain.WishlistCookie
import com.example.feautures.account.domain.User

interface AuthDataSource {

    suspend fun insert(user: User): Boolean

    suspend fun checkIfEmailExist(email: String): Boolean

    suspend fun getPassword(email: String): String?

    suspend fun syncOrders(email: String, wishlistCookie: WishlistCookie?): Boolean
}