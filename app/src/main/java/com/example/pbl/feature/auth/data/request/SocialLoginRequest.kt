package com.example.pbl.feature.auth.data.request

data class SocialLoginRequest(
    val accessToken: String,
    val socialProvider: String,
    val userRole: String
)
