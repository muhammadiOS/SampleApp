package salary.domain.usecase

import salary.domain.entities.SchoolFeesEntity
import salary.domain.repository.SalaryRepository
import javax.inject.Inject

class GetSchoolFeesUseCase @Inject constructor(
    private val repository: SalaryRepository
) {

    suspend operator fun invoke(): SchoolFeesEntity {
        return repository.getSchoolFees()
    }
}
