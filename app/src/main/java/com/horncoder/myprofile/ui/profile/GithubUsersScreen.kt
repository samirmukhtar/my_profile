package com.horncoder.myprofile.ui.profile

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.horncoder.myprofile.model.response.GithubUser

@Composable
fun GithubUsersScreen(onUserClick: (String) -> Unit, viewModel: GithubUsersViewModel = viewModel()) {

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
            UserList(onUserClick = onUserClick ,state.data)
        }
    }
}

@Composable
fun UserList(onUserClick: (String) -> Unit, data: List<GithubUser>) {
    LazyColumn {
        items(data) { user ->
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .clickable{
                        onUserClick(user.login)
                    }

            ){

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
    }
}