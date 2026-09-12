package com.horncoder.myprofile.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.horncoder.myprofile.model.response.GithubUser
import com.horncoder.myprofile.model.response.GithubUserDetail

@Composable
fun UserDetailScreen(username: String, viewModel: UserDetailViewModel = viewModel()) {

    LaunchedEffect(username) {
        viewModel.getUserDetail(username)
    }
    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        is UserDetailUiState.Error -> {
            Text(text = state.message)
        }

        UserDetailUiState.Loading -> {
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

        is UserDetailUiState.Success -> {
            UserDetail(state.data)
        }
    }
}

@Composable
fun UserDetail(user: GithubUserDetail) {
    Column {
        Row {
            AsyncImage(
                model = user.avatarUrl,
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .size(88.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)

            ) {
                Text(
                    text = user.login,
                    style = MaterialTheme.typography.titleSmall

                )
            }
        }
    }
}