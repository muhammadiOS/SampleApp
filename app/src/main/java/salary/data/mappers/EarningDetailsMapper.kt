package salary.data.mappers

import salary.data.models.EarningDetailsDTO
import salary.domain.entities.EarningDetailsEntity

fun EarningDetailsDTO.toEntity(): EarningDetailsEntity {
    return EarningDetailsEntity(
        title = title,
        value = "$value SAR"
    )
}