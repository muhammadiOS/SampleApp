package salary.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import common.UIState
import salary.presentation.viewmodel.EarningViewModel

@Composable
fun EarningScreen(
    viewModel: EarningViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getUserEarning()
    }

    when (val cureentState = state) {

        UIState.Idle -> Unit

        UIState.Loading -> {
            EarningShimmer()
        }

        is UIState.Error -> {
            EarningError(
                message = cureentState.message,
                onRetry = {
                    viewModel.getUserEarning()
                }
            )
        }

        is UIState.Success -> {
            EarningContent(
                earning = cureentState.response
            )
        }
    }
}