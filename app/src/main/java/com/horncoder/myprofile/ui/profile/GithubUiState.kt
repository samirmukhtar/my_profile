package com.horncoder.myprofile.ui.profile

import com.horncoder.myprofile.model.response.GithubUser
import com.horncoder.myprofile.model.response.GithubUserDetail

sealed interface GithubUiState {
    data object Loading: GithubUiState
    data class Success(val data: List<GithubUser>): GithubUiState
    data class Error(val message: String): GithubUiState
}

sealed interface UserDetailUiState {
    data object Loading: UserDetailUiState
    data class Success(val data: GithubUserDetail): UserDetailUiState
    data class Error(val message: String): UserDetailUiState
}