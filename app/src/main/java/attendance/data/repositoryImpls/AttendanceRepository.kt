package attendance.data.repositoryImpls

import attendance.data.mappers.toEntity
import attendance.domain.entities.AttendanceEntity
import attendance.domain.repositoryInterfaces.AttendanceRepositoryInterface

class AttendanceRepository: AttendanceRepositoryInterface {
    override suspend fun getAttendance(): AttendanceEntity {
        return RetrofitInstance.api.getAttendance().toEntity()
    }

}