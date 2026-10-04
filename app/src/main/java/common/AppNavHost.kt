package common

import AttendanceDetails.AttendanceDetailsScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import attendance.presentation.view.AttendanceScreen
import common.theme.SampleAppTheme

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRouter.AttendanceScreen.route
    ) {
        composable(AppRouter.AttendanceScreen.route) {
            SampleAppTheme {
                Scaffold() { paddingValues ->
                    AttendanceScreen(
                        modifier =  Modifier.Companion
                            .fillMaxSize()
                            .padding(paddingValues),
                        onGoToDetails = { userId ->
                            navController.navigate(AppRouter.AttendanceDetailsScreen
                                .createRoute(userId))
                        }
                    )
                }
            }
        }

        composable(route = AppRouter.AttendanceDetailsScreen.route,
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            ))  { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("id") ?: 0

            AttendanceDetailsScreen(
                userId = id,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

