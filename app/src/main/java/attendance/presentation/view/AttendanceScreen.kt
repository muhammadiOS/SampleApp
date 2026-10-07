package attendance.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import attendance.domain.entities.AttendanceEntity
import attendance.presentation.ViewModels.AttendanceViewModel
import common.UIState
import common.theme.SampleAppTheme

@Composable
fun AttendanceScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onGoToDetails: (userId: Int) -> Unit)  {

    val viewModel: AttendanceViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.fetchUserAttendance()
    }
    Column ( modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(40.dp))
        Row(modifier = Modifier.height(24.dp),
            verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = onBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }

            Text(
                text = "summary",
                style = MaterialTheme.typography.titleMedium,
                //modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter) {
            when (val currentState = state) {
                UIState.Idle -> Unit
                UIState.Loading -> {
                    LoadShimmer(modifier = modifier)
                }

                is UIState.Success -> {
                    AttendanceList(
                        modifier = modifier,
                        entity = currentState.response,
                        onGoToDetails = onGoToDetails
                    )
                }

                is UIState.Error -> {
                    LoadError(
                        modifier = modifier,
                        message = currentState.message
                    )
                }
            }
        }
    }

}

@Composable
fun LoadError(modifier: Modifier, message: String) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            color = Color.Red,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun LoadShimmer(modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Row() {
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
        }
        Spacer(Modifier.height(16.dp))
        Row() {
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
        }
        Spacer(Modifier.height(16.dp))
        Row() {
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
        }
        Spacer(Modifier.height(16.dp))
        Row() {
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
        }
        Spacer(Modifier.height(16.dp))
        Row() {
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
        }
        Spacer(Modifier.height(16.dp))
        Row() {
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
        }
        Spacer(Modifier.height(16.dp))
        Row() {
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
        }
        Spacer(Modifier.height(16.dp))
        Row() {
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
        }
        Spacer(Modifier.height(16.dp))
        Row() {
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f)) {
                AttendanceCardShimmer()
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun AttendanceList(modifier: Modifier,
                   entity: AttendanceEntity,
                   onGoToDetails: (userId: Int) -> Unit) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AttendanceHeader()
        InfoBanner(message = entity.message.description)
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Box(modifier = Modifier.weight(1f)) {
                ProgressCard(
                    percentage = entity.punctualityPercentage.toInt(),
                    title = "355 of 360",
                    subtitle = "punctuality"
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                ProgressCard(
                    percentage = entity.workedHoursPercentage.toInt(),
                    title = entity.hoursWorked,
                    subtitle = "total hours"
                )
            }
        }
        Row(
            Modifier.height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()) {
                InfoCard(
                    title = "lateness",
                    value = entity.lateness,
                    times = entity.lateness
                )
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()) {
                InfoCard(
                    title = "shortness",
                    value = entity.shortness,
                    times = entity.shortness
                )
            }
        }
        Row(
            Modifier.height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()) {
                InfoCard(
                    title = "out of stc time",
                    value = entity.outOfStcTime,
                    times = entity.outOfStcTime
                )
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()) {
                InfoCard(
                    title = "half day shortness",
                    value = entity.shortness,
                    times = entity.shortness
                )
            }
        }
        Row(
            Modifier.height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()) {
                StatCard(
                    title = "lateness/shortness",
                    value = entity.latenessAndShortnessCount
                )
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()) {
                StatCard(
                    title = "absence",
                    value = entity.absencesCount
                )
            }
        }
        AttendanceRow(
            onClick = onGoToDetails
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AttendanceScreenPreview() {


//    AttendanceList(
//        modifier = Modifier,
//        entity = AttendanceEntity.dummy(),
//        onGoToDetails = {}
//    )
    //            LoadError(modifier = Modifier.padding(paddingValues),
//                message = "dummy text Connected to the target VM, address: 'localhost:54318', transport: 'socket'")

}