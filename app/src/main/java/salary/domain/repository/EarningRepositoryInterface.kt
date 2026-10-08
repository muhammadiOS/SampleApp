package salary.domain.repository

import salary.domain.entities.EarningEntity

interface EarningRepositoryInterface {

    suspend fun get(userId: Int): EarningEntity
}
