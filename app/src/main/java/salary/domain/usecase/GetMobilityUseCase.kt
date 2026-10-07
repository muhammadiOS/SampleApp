package salary.domain.usecase

import salary.domain.entities.MobilityEntity
import salary.domain.repository.SalaryRepository
import javax.inject.Inject

class GetMobilityUseCase @Inject constructor(
    private val repository: SalaryRepository
) {

    suspend operator fun invoke(): MobilityEntity {
        return repository.getMobility()
    }
}
