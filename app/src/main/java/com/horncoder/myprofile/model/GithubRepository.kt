package com.horncoder.myprofile.model

import com.horncoder.myprofile.model.api.GithubApi
import com.horncoder.myprofile.model.response.GithubUser
import com.horncoder.myprofile.model.response.GithubUserDetail

class GithubRepository(private val api: GithubApi) {
    suspend fun getUsers(): List<GithubUser>{
        return api.getUsers()
    }

    suspend fun getUserDetail(username: String): GithubUserDetail {
        return api.getUserDetail(username)
    }

}