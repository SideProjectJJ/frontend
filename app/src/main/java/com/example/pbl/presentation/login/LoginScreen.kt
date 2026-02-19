package com.example.pbl.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onKakaoLoginClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {

        Text(
            text = "로그인",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onKakaoLoginClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFEE500)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "카카오톡으로 로그인",
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = { /* 추후 확장 */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("이메일 로그인")
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}