package salary.data.models

data class SalaryDTO(
    val item: EarningItemDTO,
    val details: List<EarningDetailsDTO>
)