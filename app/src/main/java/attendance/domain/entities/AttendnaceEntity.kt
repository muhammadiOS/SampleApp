package attendance.domain.entities

data class AttendanceEntity (
    val message: Message,
    val punctualityPercentage: String,
    val hoursWorked: String,
    val workedHoursPercentage: String,
    val lateness: String,
    val shortness: String,
    val outOfStcTime: String,
    val latenessAndShortnessCount: String,
    val absencesCount: String,
    val attendanceCounts: AttendanceCounts
)

data class AttendanceCounts (
    val duration0_20: Long,
    val duration21_60: Long,
    val duration60Plus: Long,
    val abscense: Long,
    val outOfStc: Long
)

data class Message (
    val type: String,
    val description: String
)
