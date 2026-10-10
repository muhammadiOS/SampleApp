package salary.presentation.view


import android.graphics.Color.parseColor
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import salary.domain.entities.EarningDetailsEntity
import salary.domain.entities.EarningItemEntity

@Composable
fun EarningItemCard(
    item: EarningItemEntity,
    details: List<EarningDetailsEntity>,
    modifier: Modifier = Modifier
) {

    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    expanded = !expanded
                }
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                /*
                 * Replace this with your actual icon implementation
                 */
                Text(
                    text = item.iconName,
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = Color.Red,//parseColor(item.tintColor),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(8.dp),
                    color = Color.White
                )

                Spacer(
                    modifier = Modifier.size(12.dp)
                )

                Text(
                    text = item.title,
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = {
                        expanded = !expanded
                    }
                ) {

                    Icon(
                        imageVector =
                            if (expanded) {
                                Icons.Default.KeyboardArrowUp
                            } else {
                                Icons.Default.KeyboardArrowDown
                            },
                        contentDescription =
                            if (expanded) {
                                "Collapse"
                            } else {
                                "Expand"
                            }
                    )
                }
            }

            AnimatedVisibility(
                visible = expanded
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 12.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(
                        8.dp
                    )
                ) {

                    details.forEach { detail ->

                        EarningDetailRow(
                            detail = detail
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun PreviewView() {
    EarningItemCard(
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
}