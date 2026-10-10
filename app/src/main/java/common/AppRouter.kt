package common

sealed class AppRouter(val route: String) {
    data object ProfileScreen :
        AppRouter("profile_screen/{userId}") {
        fun createRoute(id: Int) =
            "profile_screen/$id"
    }

    data object AttendanceScreen :
        AppRouter("attendance_screen")

    data object AttendanceDetailsScreen :
        AppRouter("attendance_details_screen/{id}") {
            fun createRoute(id: Int) =
                "attendance_details_screen/$id"
        }

    data object BenefitsScreen :
        AppRouter("benefits_screen/{userId}") {

        fun createRoute(id: Int) =
            "benefits_screen/$id"
    }
}