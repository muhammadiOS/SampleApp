package attendance.data.mappers
import attendance.data.models.AttendanceCountsDto
import attendance.data.models.AttendanceModel
import attendance.data.models.MessageDto
import attendance.domain.entities.AttendanceCounts
import attendance.domain.entities.AttendanceEntity
import attendance.domain.entities.Message

fun AttendanceModel.toEntity(): AttendanceEntity {
    return AttendanceEntity(
        message = data.message.toEntity(),
        punctualityPercentage = data.punctualityPercentage,
        hoursWorked = data.hoursWorked,
        workedHoursPercentage = data.workedHoursPercentage,
        lateness = data.lateness,
        shortness = data.shortness,
        outOfStcTime = data.outOfStcTime,
        latenessAndShortnessCount = data.latenessAndShortnessCount,
        absencesCount = data.absencesCount,
        attendanceCounts = data.attendanceCounts.toEntity()
    )
}

fun MessageDto.toEntity(): Message {
    return Message(
        type = type,
        description = description
    )
}

fun AttendanceCountsDto.toEntity(): AttendanceCounts {
    return AttendanceCounts(
        duration0_20 = duration020.toLong(),
        duration21_60 = duration2160.toLong(),
        duration60Plus = duration60Plus.toLong(),
        abscense = absence.toLong(),
        outOfStc = outOfStc.toLong()
    )
}