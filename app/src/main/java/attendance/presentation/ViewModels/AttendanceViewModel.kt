package attendance.presentation.ViewModels
import attendance.data.DI.RetrofitInstance
import kotlinx.coroutines.*


import attendance.domain.usecases.AttendanceUseCase
import javax.inject.Inject

class AttendanceViewModel @Inject constructor(
    private val  attendanceUseCase: AttendanceUseCase)  {

    fun fetchUserAttendance() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val attendance = attendanceUseCase.getAttendance()

                withContext(Dispatchers.Main) {
                    println(attendance)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}