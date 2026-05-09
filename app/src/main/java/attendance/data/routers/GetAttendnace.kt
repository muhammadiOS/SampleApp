package attendance.data.routers
import attendance.data.models.AttendanceModel
import retrofit2.http.GET

interface ApiService {
    @GET("attendance")
    suspend fun getAttendance(): AttendanceModel
}