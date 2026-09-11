package com.horncoder.myprofile.ui.profile

sealed interface GithubUiState {
    data object Loading: GithubUiState
    data class Success<T>(val data: T): GithubUiState
    data class Error(val message: String): GithubUiState
}