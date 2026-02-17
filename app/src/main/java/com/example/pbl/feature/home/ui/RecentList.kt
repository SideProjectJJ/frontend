package com.example.pbl.feature.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.pbl.R
import com.example.pbl.feature.home.RecordItem

@Composable
fun RecentList() {
    val records = listOf(
        RecordItem("레그 프레스", "2025.05.12 · 하체 운동", R.drawable.leg),
        RecordItem("체스트 프레스", "2025.05.10 · 가슴 운동", R.drawable.chest),
        RecordItem("랫 풀 다운", "2025.05.08 · 등 운동", R.drawable.lat)
    )

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        records.forEach {
            RecordCard(it)
        }
    }
}