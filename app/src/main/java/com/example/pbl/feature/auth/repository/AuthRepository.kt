package com.example.pbl.feature.auth.repository


import com.example.pbl.core.network.ApiClient
import com.example.pbl.feature.auth.data.request.SocialLoginRequest


class AuthRepository {

    suspend fun login(request: SocialLoginRequest) =
        ApiClient.authApi.socialLogin(request)
}