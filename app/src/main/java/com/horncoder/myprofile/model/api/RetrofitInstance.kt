package com.horncoder.myprofile.model.api

import com.horncoder.myprofile.model.response.GithubUser
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
//    private val api: GithubApi
    private const val BASE_URL = "https://api.github.com/"


//    init {

        val api: GithubApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubApi::class.java)
        }

//        api = retrofit.create(GithubApi::class.java)


//    suspend fun getUsers(): List<GithubUser>{
//        return api.getUsers()
//    }

}