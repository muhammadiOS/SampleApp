package salary.domain.repository

import salary.domain.entities.LoanEntity
import salary.domain.entities.MobilityEntity
import salary.domain.entities.SalaryEntity
import salary.domain.entities.SchoolFeesEntity

interface SalaryRepository {

    suspend fun getSalary(): SalaryEntity

    suspend fun getMobility(): MobilityEntity

    suspend fun getSchoolFees(): SchoolFeesEntity

    suspend fun getLoans(): List<LoanEntity>
}
