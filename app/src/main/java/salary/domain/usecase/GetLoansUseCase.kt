package salary.domain.usecase

import salary.domain.entities.LoanEntity
import salary.domain.repository.SalaryRepository
import javax.inject.Inject

class GetLoansUseCase @Inject constructor(
    private val repository: SalaryRepository
) {

    suspend operator fun invoke(): List<LoanEntity> {
        return repository.getLoans()
    }
}
