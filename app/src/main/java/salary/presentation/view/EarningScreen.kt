package salary.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import common.AppHeader
import common.UIState
import salary.presentation.viewmodel.EarningViewModel

@Composable
fun EarningScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    ) {
    val viewModel: EarningViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getUserEarning()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        AppHeader(title = "Earning", onBack = onBack)
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

}