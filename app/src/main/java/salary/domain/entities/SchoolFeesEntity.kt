package salary.domain.entities


data class SchoolFeesEntity(
    val item: EarningItemEntity,
    val details: List<EarningDetailsEntity>
)
