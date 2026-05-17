package attendance.presentation.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProgressCard(
    percentage: Int,
    title: String,
    subtitle: String
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth().aspectRatio(4f/5f),

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {

            Box(contentAlignment = Alignment.Center) {

                Canvas(modifier = Modifier.size(80.dp)) {
                    drawArc(
                        color = Color.LightGray,
                        startAngle = 0f,
                        sweepAngle = 360f,
                        useCenter = false,
                        style = Stroke(4.dp.toPx())
                    )

                    drawArc(
                        color = Color(0xFF8E24AA),
                        startAngle = -90f,
                        sweepAngle = (percentage / 100f) * 360f,
                        useCenter = false,
                        style = Stroke(4.dp.toPx())
                    )
                }

                Text("$percentage%")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(subtitle)
            Text(title, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressCardPreview() {
    ProgressCard(
        percentage = 70,
        title = "title",
        subtitle = "subtitle"
    )
}