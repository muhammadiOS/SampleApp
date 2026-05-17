package attendance.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InfoBanner(message: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFF3CD), RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Icon(Icons.Default.Info, contentDescription = "")
        Spacer(modifier = Modifier.width(8.dp))
        Text(message)
    }
}


@Preview(showBackground = true)
@Composable
fun InfoBannerPreview() {
    InfoBanner(message = "you’re viewing attendance up to yesterday")
}