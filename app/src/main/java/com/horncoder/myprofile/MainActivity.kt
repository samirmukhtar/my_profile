package com.horncoder.myprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.horncoder.myprofile.ui.profile.GithubUsersScreen
import com.horncoder.myprofile.ui.profile.UserDetail
import com.horncoder.myprofile.ui.profile.UserDetailScreen
import com.horncoder.myprofile.ui.profile.UserDetails
import com.horncoder.myprofile.ui.profile.Users
import com.horncoder.myprofile.ui.theme.MyProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyProfileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ){
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = Users
                        ) {

                            composable<Users> {
                                GithubUsersScreen(
                                    onUserClick = { username ->
                                        navController.navigate(

                                            UserDetails(username)
                                        )
                                    }
                                )
                            }

                            composable<UserDetails> { backStackEntry ->

                                val route =
                                    backStackEntry.toRoute<UserDetails>()

                                UserDetailScreen(
                                    username = route.username
                                )
                            }
                        }
//                        GithubUsersScreen()
                    }
                }
            }
        }
    }
}

