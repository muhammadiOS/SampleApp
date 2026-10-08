package salary.data.mappers

import salary.data.models.SalaryDTO
import salary.domain.entities.SalaryEntity


fun SalaryDTO.toEntity(): SalaryEntity {
    return SalaryEntity(
        item = item.toEntity(),
        details = details.map { it.toEntity() }
    )
}