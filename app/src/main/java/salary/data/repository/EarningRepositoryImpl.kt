package salary.data.repository

import salary.data.mappers.toEntity
import salary.data.routers.EarningService
import salary.domain.entities.EarningEntity
import salary.domain.repository.EarningRepositoryInterface


import javax.inject.Inject

class EarningRepositoryImpl @Inject constructor(
    private val earningService: EarningService
) : EarningRepositoryInterface {

    override suspend fun get(userId: Int): EarningEntity {
        return earningService.get(
            userId = userId
        ).toEntity()
    }
}