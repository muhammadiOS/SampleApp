package attendance.data.repositoryImpls

import attendance.data.DI.RetrofitInstance
import attendance.data.mappers.toEntity
import attendance.data.routers.ApiService
import attendance.domain.entities.AttendanceEntity
import attendance.domain.repositoryInterfaces.AttendanceRepositoryInterface
import javax.inject.Inject

class AttendanceRepository @Inject constructor( private val api: ApiService): AttendanceRepositoryInterface {
    override suspend fun getAttendance(): AttendanceEntity {
        return api.getAttendance().toEntity()
    }
}