package salary.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import common.shimmer
@Composable
fun EarningShimmer() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        repeat(4) {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .shimmer(),
                shape = RoundedCornerShape(16.dp)
            ) {}
        }
    }
}


@Preview(
    showBackground = true,
)
@Composable
private fun PreviewView() {
    EarningShimmer()
}