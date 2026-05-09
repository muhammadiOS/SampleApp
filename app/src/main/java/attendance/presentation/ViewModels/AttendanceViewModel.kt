package attendance.presentation.ViewModels
import kotlinx.coroutines.*


import attendance.domain.usecases.AttendanceUseCase

class AttendanceViewModel {
    private val  attendanceUseCase = AttendanceUseCase()


    fun fetchUserAttendance() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val attendance = RetrofitInstance.api.getAttendance()

                withContext(Dispatchers.Main) {
                    println(attendance)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}