package salary.domain.usecase

import salary.domain.entities.EarningEntity
import salary.domain.repository.EarningRepositoryInterface
import javax.inject.Inject

class GetEarningUseCase @Inject constructor(
    private val repository: EarningRepositoryInterface
) {

    suspend operator fun invoke(userId: Int): EarningEntity {
        return repository.get(userId)
    }
}
