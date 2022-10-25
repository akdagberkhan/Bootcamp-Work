package com.merttoptas.retrofittutorial.data.repository

import com.merttoptas.retrofittutorial.data.model.Users
import retrofit2.Call

interface UsersRepository {
    fun getUsers(): Call<List<Users>>
}