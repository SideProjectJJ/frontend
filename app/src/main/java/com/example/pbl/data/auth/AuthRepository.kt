package com.example.pbl.data.auth

import com.example.pbl.core.network.ApiClient
import com.example.pbl.data.auth.SocialLoginRequest

class AuthRepository {

    suspend fun login(request: SocialLoginRequest) =
        ApiClient.authApi.socialLogin(request)
}