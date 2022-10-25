package com.akdagberkhan.retrofitexample.data.model

import com.google.gson.annotations.SerializedName

data class Post(

    @SerializedName("body")
    val body : String?,
    @SerializedName("userId")
    val userId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?

)