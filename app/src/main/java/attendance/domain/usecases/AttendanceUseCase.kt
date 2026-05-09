package attendance.domain.usecases

import attendance.domain.entities.AttendanceEntity
import attendance.domain.repositoryInterfaces.AttendanceRepositoryInterface

class AttendanceUseCase() {
    private lateinit var attendanceRepository: AttendanceRepositoryInterface
    suspend fun  getAttendance(): AttendanceEntity {
       return attendanceRepository.getAttendance()
    }
}