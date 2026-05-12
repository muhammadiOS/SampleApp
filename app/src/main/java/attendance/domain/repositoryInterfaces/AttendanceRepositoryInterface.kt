package attendance.domain.repositoryInterfaces

import attendance.data.routers.ApiService
import attendance.domain.entities.AttendanceEntity
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

interface AttendanceRepositoryInterface {
    suspend fun getAttendance():  AttendanceEntity
}