package attendance.domain.usecases

import attendance.domain.entities.AttendanceEntity
import attendance.domain.repositoryInterfaces.AttendanceRepositoryInterface
import javax.inject.Inject


class AttendanceUseCase @Inject constructor(
    private val attendanceRepository: AttendanceRepositoryInterface
) {

    suspend fun  getAttendance(): AttendanceEntity {
       return attendanceRepository.getAttendance()
    }
}

