package com.horncoder.myprofile.model.api

import com.horncoder.myprofile.model.response.GithubUser
import com.horncoder.myprofile.model.response.GithubUserDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users")
    suspend fun getUsers(): List<GithubUser>

    @GET("users/{username}")
    suspend fun getUserDetail(
        @Path("username") username: String
    ): GithubUserDetail

}