package attendance.domain.repositoryInterfaces

import attendance.domain.entities.AttendanceEntity

interface AttendanceRepositoryInterface {
    suspend fun getAttendance():  AttendanceEntity
}