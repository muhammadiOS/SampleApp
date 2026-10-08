package salary.domain.entities

data class SalaryEntity(
    val item: EarningItemEntity,
    val details: List<EarningDetailsEntity>,
    ) {
    companion object {
        fun dummy(): SalaryEntity {
            val earnings = EarningDetailsEntity(
                title = "Earnings",
                value = "10,000.0 SAR"
            )
            val deducted = EarningDetailsEntity(
                title = "Deducted",
                value = "100.0 SAR"
            )
            val bonus = EarningDetailsEntity(
                title = "Bonus",
                value = "300.0 SAR"
            )
            return SalaryEntity(
                item = EarningItemEntity(
                    title = "Salary",
                    iconName = "salary",
                    tintColor = "#6A1B9A"
                ),
                details = listOf(earnings, deducted, bonus)
            )
        }
    }
}