package common

import AttendanceDetails.AttendanceDetailsScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import attendance.presentation.view.AttendanceScreen
import common.theme.SampleAppTheme

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Attendance"
    ) {
        composable("Attendance") {
            SampleAppTheme {
                Scaffold() { paddingValues ->
                    AttendanceScreen(
                        modifier =  Modifier.Companion.fillMaxSize()
                            .padding(paddingValues),
                        navController = navController
                    )
                }
            }
        }

        composable("details") {
            AttendanceDetailsScreen(
                navController = navController
            )
        }
    }
}


