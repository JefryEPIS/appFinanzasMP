package com.example.appfinanzas2.pantallas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos
import kotlin.math.sin

@Preview
@Composable
fun BalanceScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = "Pantalla 3",
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Main content card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 8.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                // Pie Chart
                PieChart(
                    modifier = Modifier.size(200.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Balance Amount
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "$248.57",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "Available Balance",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Statistics Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatisticItem(
                        title = "Earning",
                        value = "253.6",
                        color = Color.Gray
                    )
                    StatisticItem(
                        title = "Spend",
                        value = "587.4",
                        color = Color(0xFF00BCD4)
                    )
                    StatisticItem(
                        title = "Available",
                        value = "729.7",
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bottom Navigation
        BottomNavigationBar()
    }
}

@Composable
fun PieChart(modifier: Modifier = Modifier) {
    val data = listOf(
        PieData(40f, Color(0xFF2196F3)), // Blue
        PieData(35f, Color(0xFFF44336)), // Red
        PieData(25f, Color(0xFF00BCD4))  // Cyan
    )

    Canvas(modifier = modifier) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val radius = minOf(canvasWidth, canvasHeight) / 2f - 20.dp.toPx()
        val center = androidx.compose.ui.geometry.Offset(canvasWidth / 2f, canvasHeight / 2f)

        var startAngle = -90f

        data.forEach { pieData ->
            val sweepAngle = (pieData.percentage / 100f) * 360f

            drawArc(
                color = pieData.color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true,
                topLeft = androidx.compose.ui.geometry.Offset(
                    center.x - radius,
                    center.y - radius
                ),
                size = androidx.compose.ui.geometry.Size(radius * 2, radius * 2)
            )

            // Draw icons (simplified as small circles)
            val iconAngle = Math.toRadians((startAngle + sweepAngle / 2).toDouble())
            val iconRadius = radius * 0.7f
            val iconX = center.x + (iconRadius * cos(iconAngle)).toFloat()
            val iconY = center.y + (iconRadius * sin(iconAngle)).toFloat()

            drawCircle(
                color = Color.White,
                radius = 12.dp.toPx(),
                center = androidx.compose.ui.geometry.Offset(iconX, iconY)
            )

            startAngle += sweepAngle
        }

        // Draw white circle in center
        drawCircle(
            color = Color.White,
            radius = radius * 0.3f,
            center = center
        )
    }
}

@Composable
fun StatisticItem(
    title: String,
    value: String,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            color = Color.Gray
        )
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = color,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun BottomNavigationBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomNavItem(
                icon = Icons.Default.Home,
                label = "Inicio",
                isSelected = true
            )
            BottomNavItem(
                icon = Icons.Default.Home,
                label = "Registrar",
                isSelected = false
            )
            BottomNavItem(
                icon = Icons.Default.Menu,
                label = "Listar",
                isSelected = false
            )
            BottomNavItem(
                icon = Icons.Default.Person,
                label = "Sobre mi",
                isSelected = false
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    isSelected: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isSelected) Color(0xFF2196F3) else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            fontSize = 10.sp,
            color = if (isSelected) Color(0xFF2196F3) else Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

data class PieData(
    val percentage: Float,
    val color: Color
)

@Preview(showBackground = true)
@Composable
fun PreviewBalanceScreen() {
    BalanceScreen()
}