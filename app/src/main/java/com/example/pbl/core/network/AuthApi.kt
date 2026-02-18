package com.example.pbl.core.network
import com.example.pbl.data.auth.SocialLoginRequest
import com.example.pbl.data.auth.AuthTokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("api/v1/auth/login")
    suspend fun socialLogin(
        @Body request: SocialLoginRequest
    ): Response<AuthTokenResponse>
}
