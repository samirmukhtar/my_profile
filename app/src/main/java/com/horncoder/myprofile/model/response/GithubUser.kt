package com.horncoder.myprofile.model.response

import com.google.gson.annotations.SerializedName

data class GithubUser(
    val id: String,
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String,
)
