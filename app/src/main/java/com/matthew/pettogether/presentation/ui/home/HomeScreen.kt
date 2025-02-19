package com.matthew.pettogether.presentation.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.Museum
import androidx.compose.material.icons.filled.Park
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Route
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.SportsBasketball
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.matthew.pettogether.domain.model.Category
import com.matthew.pettogether.ui.theme.Black200
import com.matthew.pettogether.ui.theme.Gray200
import com.matthew.pettogether.ui.theme.Gray50
import com.matthew.pettogether.ui.theme.PetTogetherTheme
import com.matthew.pettogether.ui.theme.White

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Gray50),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        HomeTopBar()
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            border = BorderStroke(1.dp, Gray200),
            colors = CardDefaults.cardColors(
                containerColor = White
            )
        ) {
            CategoryGrid(
                categories = viewModel.categories.collectAsState().value,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}

@Composable
fun HomeTopBar(modifier: Modifier = Modifier) {
    Surface(
        color = White,
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Pets,
                contentDescription = "펫 투게더 로고",
                modifier = Modifier.size(32.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "펫 투게더",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
fun CategoryGrid(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(categories) { category ->
            CategoryItem(category = category)
        }
        item {
            CategoryItem(
                category = Category(code = "DEV", name = "개발중..."),
                isDevelopment = true
            )
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    isDevelopment: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        val (icon, iconTint) = when(category.code) {
            "A01" -> Icons.Filled.Park to Color(0xFF4CAF50)  // 자연 - 초록
            "A02" -> Icons.Filled.Museum to Color(0xFF9C27B0)  // 문화 - 보라
            "A03" -> Icons.Filled.SportsBasketball to Color(0xFF2196F3)  // 레포츠 - 파랑
            "A04" -> Icons.Filled.ShoppingCart to Color(0xFFE91E63)  // 쇼핑 - 분홍
            "A05" -> Icons.Filled.Restaurant to Color(0xFFFF9800)  // 음식 - 주황
            "B02" -> Icons.Filled.Hotel to Color(0xFF795548)  // 숙박 - 갈색
            "C01" -> Icons.Filled.Route to Color(0xFF607D8B)  // 추천코스 - 회색
            "DEV" -> Icons.Filled.Build to Color(0xFF9E9E9E)  // 개발중 - 회색
            else -> Icons.Filled.Place to MaterialTheme.colorScheme.primary
        }
        
        Icon(
            imageVector = icon,
            contentDescription = category.name,
            modifier = Modifier
                .size(32.dp)
                .padding(bottom = 2.dp),
            tint = if (isDevelopment) {
                Color.Gray.copy(alpha = 0.5f)
            } else {
                iconTint
            }
        )
        
        Text(
            text = category.name,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 2.dp),
            maxLines = 1,
            color = if (isDevelopment) {
                Color.Gray.copy(alpha = 0.7f)
            } else {
                Black200
            }
        )
    }
}

// Preview를 위한 가짜 데이터
private val previewCategories = listOf(
    Category(code = "A01", name = "자연"),
    Category(code = "A02", name = "인문(문화/예술/역사)"),
    Category(code = "A03", name = "레포츠"),
    Category(code = "A04", name = "쇼핑"),
    Category(code = "A05", name = "음식"),
    Category(code = "B02", name = "숙박"),
    Category(code = "C01", name = "추천코스")
)

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PetTogetherTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            HomeTopBar()
            CategoryGrid(
                categories = previewCategories,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeTopBarPreview() {
    PetTogetherTheme {
        HomeTopBar()
    }
}