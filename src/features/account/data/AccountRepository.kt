package com.example.features.account.data

import com.example.database.user.UserDataSource
import com.example.features.account.domain.User

class AccountRepository(
    private val userDataSource: UserDataSource
) {
    suspend fun getUser(email: String): User? {
        return userDataSource.getUser(email)
    }

    suspend fun updateUser(user: User): Boolean {
        return userDataSource.updateUser(user)
    }
}