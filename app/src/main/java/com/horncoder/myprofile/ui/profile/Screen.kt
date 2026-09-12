package com.horncoder.myprofile.ui.profile
import kotlinx.serialization.Serializable
@Serializable
object Users

@Serializable
data class UserDetails(val username: String)
