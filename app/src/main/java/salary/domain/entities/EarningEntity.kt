package salary.domain.entities

data class EarningEntity(
    val salary: SalaryEntity,
    val loan: LoanEntity,
    val schoolFees: SchoolFeesEntity,
    val mobility: MobilityEntity
)