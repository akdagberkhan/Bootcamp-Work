package com.akdagberkhan.retrofitexample.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        private lateinit var apiService: ApiService

        fun getApiService(): ApiService {

            if (!::apiService.isInitialized) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService
        }
    }

}