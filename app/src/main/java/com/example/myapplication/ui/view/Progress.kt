package com.example.myapplication.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.common.purple200opaque99

@Composable
fun Progress(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth().wrapContentSize(Alignment.Center)) {
        Box(
            modifier = modifier.preferredSize(100.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(purple200opaque99)
        ) {
            CircularProgressIndicator(
                Modifier.align(Alignment.Center),
                color = Color.White
            )
        }
    }
}