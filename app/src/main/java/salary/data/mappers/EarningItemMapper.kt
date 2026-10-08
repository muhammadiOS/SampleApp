package salary.data.mappers

import salary.data.models.EarningItemDTO
import salary.domain.entities.EarningItemEntity

fun EarningItemDTO.toEntity(): EarningItemEntity {
    return EarningItemEntity(
        title = title,
        iconName = iconName,
        tintColor = tintColor
    )
}