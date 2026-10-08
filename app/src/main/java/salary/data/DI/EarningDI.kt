package salary.data.DI

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import salary.data.repository.EarningRepositoryImpl
import salary.domain.repository.EarningRepositoryInterface


@Module
@InstallIn(ViewModelComponent::class)
abstract class EarningRepositoryModule {

    @Binds
    abstract fun bindEarningRepository (
        earningRepositoryImpl: EarningRepositoryImpl
    ): EarningRepositoryInterface
}