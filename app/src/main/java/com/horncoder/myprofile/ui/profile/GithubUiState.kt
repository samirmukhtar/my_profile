package com.horncoder.myprofile.ui.profile

import com.horncoder.myprofile.model.response.GithubUser

sealed interface GithubUiState {
    data object Loading: GithubUiState
    data class Success(val data: List<GithubUser>): GithubUiState
    data class Error(val message: String): GithubUiState
}