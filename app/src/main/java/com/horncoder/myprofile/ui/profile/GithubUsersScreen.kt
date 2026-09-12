package com.horncoder.myprofile.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GithubUsersScreen(viewModel: GithubUsersViewModel = viewModel()) {
//    val users = viewModel.usersState.value
    val names = listOf("Alice", "Bob", "Charlie")

    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        is GithubUiState.Error -> {
            Text(text = state.message)
        }

        GithubUiState.Loading -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is GithubUiState.Success -> {
            LazyColumn {
                items(state.data){user ->
                    Text(text = user.login)
                }
            }
//            Text(text = "j")
        }

    }
}

//@Composable
//fun UserDetail(data: GithubUser) {
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//    ) {
//        items(5) {
//            Text(text = "1")
//        }
//    }
//}