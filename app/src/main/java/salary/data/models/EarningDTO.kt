package salary.data.models

data class EarningDTO (
    val salary: SalaryDTO,
    val loan: LoanDTO,
    val schoolFees: SchoolFeesDTO,
    val mobility: MobilityDTO
)
