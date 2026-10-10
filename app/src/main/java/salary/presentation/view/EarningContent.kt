package salary.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import salary.domain.entities.EarningEntity

@Composable
fun EarningContent (
    earning: EarningEntity
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            EarningItemCard(
                item = earning.salary.item,
                details = earning.salary.details
            )
        }
        item {
            EarningItemCard(
                item = earning.mobility.item,
                details = earning.mobility.details
            )
        }
        item {
            EarningItemCard(
                item = earning.schoolFees.item,
                details = earning.schoolFees.details
            )
        }
        item {
            EarningItemCard(
                item = earning.loan.item,
                details = earning.loan.details
            )
        }
    }
}