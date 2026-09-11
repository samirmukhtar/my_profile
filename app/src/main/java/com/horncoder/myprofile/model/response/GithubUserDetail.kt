package com.horncoder.myprofile.model.response

import com.google.gson.annotations.SerializedName

data class GithubUserDetail(
    val id: String,
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    val name: String,
    val followers: String,
    val following: String

)
