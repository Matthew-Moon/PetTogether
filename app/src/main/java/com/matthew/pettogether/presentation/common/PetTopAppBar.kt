package com.viva.viva_kindoc.compose.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matthew.pettogether.ui.theme.Typography
import com.matthew.pettogether.ui.theme.Black200
import com.matthew.pettogether.ui.theme.White

@Composable
fun PetTopAppbar(
    title: String,
    isRightButton: Boolean = false,
    onLeftClick: () -> Unit
) {
    Box(modifier = Modifier.background(White)) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(44.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LeftButton(onLeftClick)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = title,
                color = Black200,
                style = Typography.bodyMedium
            )
            Spacer(modifier = Modifier.weight(1f))
            RightButton(isRightButton)
        }
    }
}

@Composable
private fun LeftButton(onLeftClick: () -> Unit) {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = "뒤로가기",
        tint = Black200,
        modifier = Modifier
            .clickable(
                onClick = { onLeftClick() },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .size(24.dp)
    )
}

@Composable
private fun RightButton(isRightButton: Boolean) {
    if (isRightButton) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "검색",
            tint = Black200,
            modifier = Modifier
                .clickable(
                    onClick = { },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
                .size(24.dp)
        )
    } else {
        Spacer(
            modifier = Modifier
                .background(White)
                .size(24.dp)
        )
    }
}

@Preview
@Composable
private fun PetTopAppbarPreivew() {
    PetTopAppbar("제목", true, onLeftClick = {})
}