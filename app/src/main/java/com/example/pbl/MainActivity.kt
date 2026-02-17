package com.example.pbl

import android.os.Build
import com.kakao.sdk.user.UserApiClient
import android.widget.Toast
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.pbl.feature.home.ui.HomeScreen
import com.example.pbl.ui.theme.PblTheme
import okhttp3.internal.concurrent.TaskRunner.Companion.logger

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger.info { BuildConfig.KAKAO_NATIVE_KEY }
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
    private fun kakaoLogin() {
        // 카카오톡 설치 여부 확인
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {

            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                if (error != null) {
                    Toast.makeText(this, "카카오톡 로그인 실패", Toast.LENGTH_SHORT).show()
                } else if (token != null) {
                    Toast.makeText(this, "카카오톡 로그인 성공", Toast.LENGTH_SHORT).show()
                    getUserInfo()
                }
            }

        } else {

            UserApiClient.instance.loginWithKakaoAccount(this) { token, error ->
                if (error != null) {
                    Toast.makeText(this, "카카오계정 로그인 실패", Toast.LENGTH_SHORT).show()
                } else if (token != null) {
                    Toast.makeText(this, "카카오계정 로그인 성공", Toast.LENGTH_SHORT).show()
                    getUserInfo()
                }
            }
        }
    }
    private fun getUserInfo() {
        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Toast.makeText(this, "사용자 정보 요청 실패", Toast.LENGTH_SHORT).show()
            } else if (user != null) {
                val nickname = user.kakaoAccount?.profile?.nickname
                Toast.makeText(this, "환영합니다 $nickname", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
