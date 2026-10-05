package attendance.data.DI

import attendance.data.repositoryImpls.AttendanceRepository
import attendance.domain.repositoryInterfaces.AttendanceRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAttendanceRepository (
        attendanceRepositoryImpl: AttendanceRepository
    ): AttendanceRepositoryInterface
}