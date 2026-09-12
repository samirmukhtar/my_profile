package com.horncoder.myprofile.ui.profile

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horncoder.myprofile.model.GithubRepository
import com.horncoder.myprofile.model.api.NetworkResponse
import com.horncoder.myprofile.model.api.RetrofitInstance
import com.horncoder.myprofile.model.response.GithubUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GithubUsersViewModel: ViewModel() {
private val repository = GithubRepository(RetrofitInstance.api)
    private val _uiState = MutableStateFlow<GithubUiState>(GithubUiState.Loading)
    val uiState = _uiState
    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            _uiState.value = GithubUiState.Loading
            try {
                val users = repository.getUsers()
                _uiState.value = GithubUiState.Success(users)
            }
            catch (e: Exception){
                _uiState.value = GithubUiState.Error(e.message ?: "something went wrong!")
            }
        }
    }
}