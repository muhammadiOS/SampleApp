package salary.data.mappers

import salary.data.models.EarningDTO
import salary.domain.entities.EarningEntity
import salary.domain.entities.SchoolFeesEntity


fun EarningDTO.toEntity(): EarningEntity {
    return EarningEntity(
        salary = salary.toEntity(),
        loan = loan.toEntity(),
        schoolFees = schoolFees.toEntity(),
        mobility = mobility.toEntity()
    )
}