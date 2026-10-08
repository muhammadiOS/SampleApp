package salary.domain.entities

data class LoanEntity(
    val item: EarningItemEntity,
    var details: List<EarningDetailsEntity>
) {
    companion object {
        fun dummy(): LoanEntity {
            val total = EarningDetailsEntity(
                title = "Total",
                value = "10,000.0 SAR"
            )
            return LoanEntity(
                item = EarningItemEntity(
                    title = "Loans",
                    iconName = "loan",
                    tintColor = "#6A1B9A"
                ),
                details = listOf(total)
            )
        }

    }
}
