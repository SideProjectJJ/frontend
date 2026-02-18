package com.example.pbl.feature.auth.ui
import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pbl.feature.auth.data.request.SocialLoginRequest
import com.example.pbl.feature.auth.repository.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository = AuthRepository()

    fun loginWithKakao(accessToken: String) {
        Log.d(accessToken,accessToken)
        viewModelScope.launch {

            val request = SocialLoginRequest(
                accessToken = accessToken,
                socialProvider = "KAKAO",
                userRole = "USER"
            )
            Log.d("LOGIN_TEST", "loginWithKakao 호출됨")

            try {
                val response = repository.login(request)
                Log.d("LOGIN_TEST", "응답 코드: ${response.code()}")
                Log.d("LOGIN_TEST", "응답 바디: ${response.body()}")
            } catch (e: Exception) {
                Log.e("LOGIN_TEST", "에러 발생", e)
            }
        }
    }
}
