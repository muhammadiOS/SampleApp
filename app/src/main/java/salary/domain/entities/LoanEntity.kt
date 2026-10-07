package salary.domain.entities

data class LoanEntity(
    val title: String,
    val amount: Double? = null,
    val remainingAmount: Double? = null,
    val description: String? = null
)
