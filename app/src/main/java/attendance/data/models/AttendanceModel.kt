package attendance.data.models
import com.google.gson.annotations.SerializedName

data class AttendanceModel(
    @SerializedName("data")
    val data: DataDto
)

data class DataDto(
    @SerializedName("message")
    val message: MessageDto,

    @SerializedName("punctuality_percentage")
    val punctualityPercentage: String,

    @SerializedName("hours_worked")
    val hoursWorked: String,

    @SerializedName("worked_hours_percentage")
    val workedHoursPercentage: String,

    @SerializedName("lateness")
    val lateness: String,

    @SerializedName("shortness")
    val shortness: String,

    @SerializedName("out_of_stc_time")
    val outOfStcTime: String,

    @SerializedName("lateness_and_shortness_count")
    val latenessAndShortnessCount: String,

    @SerializedName("absences_count")
    val absencesCount: String,

    @SerializedName("attendance_counts")
    val attendanceCounts: AttendanceCountsDto
)

data class MessageDto(
    @SerializedName("type")
    val type: String,

    @SerializedName("description")
    val description: String
)

data class AttendanceCountsDto(
    @SerializedName("duration_0_20")
    val duration020: Int,

    @SerializedName("duration_21_60")
    val duration2160: Int,

    @SerializedName("duration_60Plus")
    val duration60Plus: Int,

    @SerializedName("abscense")
    val absence: Int,

    @SerializedName("out_of_stc")
    val outOfStc: Int
)