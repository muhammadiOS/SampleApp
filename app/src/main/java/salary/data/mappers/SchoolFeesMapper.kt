package salary.data.mappers


import salary.domain.entities.SchoolFeesEntity

fun salary.data.models.SchoolFeesDTO.toEntity(): SchoolFeesEntity {
    return SchoolFeesEntity(
        item = item.toEntity(),
        details = details.map { it.toEntity() }
    )
}