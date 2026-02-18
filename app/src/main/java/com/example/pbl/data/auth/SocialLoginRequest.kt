package com.example.pbl.data.auth

data class SocialLoginRequest(
    val accessToken: String,
    val socialProvider: String,
    val userRole: String
)