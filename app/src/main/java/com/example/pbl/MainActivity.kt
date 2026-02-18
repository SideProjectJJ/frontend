package com.example.pbl

import android.os.Build
import com.kakao.sdk.user.UserApiClient
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.pbl.feature.auth.ui.LoginViewModel
import com.example.pbl.feature.home.ui.HomeScreen
import com.example.pbl.ui.theme.PblTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PblTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                        onKakaoLoginClick = {
                            kakaoLogin()
                        }
                    )
                }
            }
        }
    }
    private val loginViewModel: LoginViewModel by viewModels()

    private fun kakaoLogin() {
        val callback: (token: com.kakao.sdk.auth.model.OAuthToken?, error: Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e("LOGIN_TEST", "카카오계정으로 로그인 실패", error)
            } else if (token != null) {
                Log.i("LOGIN_TEST", "카카오계정으로 로그인 성공 ${token.accessToken}")
                loginViewModel.loginWithKakao(token.accessToken)
            }
        }

        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
        }
    }
}
