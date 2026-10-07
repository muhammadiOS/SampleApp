package salary.domain.usecase

import salary.domain.entities.SalaryEntity
import salary.domain.repository.SalaryRepository
import javax.inject.Inject

class GetSalaryUseCase @Inject constructor(
    private val repository: SalaryRepository
) {

    suspend operator fun invoke(): SalaryEntity {
        return repository.getSalary()
    }
}
