package salary.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import salary.domain.entities.EarningDetailsEntity
import salary.domain.entities.EarningEntity
import salary.domain.entities.EarningItemEntity
import salary.domain.entities.LoanEntity
import salary.domain.entities.SalaryEntity
import salary.domain.entities.MobilityEntity
import salary.domain.entities.SchoolFeesEntity

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


@Preview(
    showBackground = true,
)
@Composable
private fun PreviewView() {
    EarningContent(
        earning = EarningEntity(
            salary = SalaryEntity(
                item = EarningItemEntity(
                    title = "Salary",
                    iconName = "salary",
                    tintColor = "#6A1B9A"
                ),
                details = listOf(
                    EarningDetailsEntity(
                        title = "Total",
                        value = "10,000.0 SAR"
                    )
                )
            ),
            mobility = MobilityEntity(
                item = EarningItemEntity(
                    title = "Mobility",
                    iconName = "mobility",
                    tintColor = "#6A1B9A"
                ),
                details = listOf(
                    EarningDetailsEntity(
                        title = "Total",
                        value = "10,000.0 SAR"
                    )
                )
            ),
            schoolFees = SchoolFeesEntity(
                item = EarningItemEntity(
                    title = "School Fees",
                    iconName = "school_fees",
                    tintColor = "#6A1B9A"
                ),
                details = listOf(
                    EarningDetailsEntity(
                        title = "Total",
                        value = "10,000.0 SAR"
                    )
                )
            ),
            loan = LoanEntity(
                item = EarningItemEntity(
                    title = "Loans",
                    iconName = "loan",
                    tintColor = "#6A1B9A"
                ),
                details = listOf(
                    EarningDetailsEntity(
                        title = "Total",
                        value = "10,000.0 SAR"
                    )
                )
            )
        )
    )
}