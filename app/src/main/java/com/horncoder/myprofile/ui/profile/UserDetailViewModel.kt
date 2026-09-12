package com.horncoder.myprofile.ui.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horncoder.myprofile.model.GithubRepository
import com.horncoder.myprofile.model.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserDetailViewModel: ViewModel() {
    private val repository = GithubRepository(RetrofitInstance.api)
    private val _uiState = MutableStateFlow<UserDetailUiState>(UserDetailUiState.Loading)
    val uiState = _uiState

    fun getUserDetail(username: String) {
        viewModelScope.launch {
            _uiState.value = UserDetailUiState.Loading
            try {
                val user = repository.getUserDetail(username)
                _uiState.value = UserDetailUiState.Success(user)
            }
            catch (e: Exception){
                _uiState.value = UserDetailUiState.Error(e.message ?: "something went wrong!")

            }
        }
    }
}