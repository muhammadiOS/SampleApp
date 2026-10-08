package salary.data.mappers

import salary.data.models.LoanDTO
import salary.domain.entities.LoanEntity

fun LoanDTO.toEntity(): LoanEntity {
    return LoanEntity(
        item = item.toEntity(),
        details = details.map { it.toEntity() }
    )
}