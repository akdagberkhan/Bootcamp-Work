package com.merttoptas.retrofittutorial.data.repository

import com.merttoptas.retrofittutorial.data.model.Users
import com.merttoptas.retrofittutorial.data.remote.api.UsersService
import retrofit2.Call

class UsersRepositoryImpl constructor(
    private val userService: UsersService
) : UsersRepository {

    override fun getUsers(): Call<List<Users>> {
        return userService.getUsers()
    }
}