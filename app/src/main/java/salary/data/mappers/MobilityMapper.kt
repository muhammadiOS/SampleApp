package salary.data.mappers

import salary.data.models.LoanDTO
import salary.domain.entities.LoanEntity
import salary.domain.entities.MobilityEntity

fun salary.data.models.MobilityDTO.toEntity(): MobilityEntity {
    return MobilityEntity(
        item = item.toEntity(),
        details = details.map { it.toEntity() }
    )
}