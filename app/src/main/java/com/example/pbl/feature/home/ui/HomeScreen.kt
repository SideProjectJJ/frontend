package com.example.pbl.feature.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        HeaderSection()
        Spacer(modifier = Modifier.height(24.dp))
        CaptureCard()
        Spacer(modifier = Modifier.height(24.dp))
        RecentHeader()
        Spacer(modifier = Modifier.height(16.dp))
        RecentList()
    }
}