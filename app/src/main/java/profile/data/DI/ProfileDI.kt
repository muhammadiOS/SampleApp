package profile.data.DI

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import profile.data.repositoryImpls.UserInfoSectionRepository
import profile.data.repositoryImpls.UserMainInfoRepository
import profile.domain.repositoryInterfaces.UserInfoSectionRepositoryInterface
import profile.domain.repositoryInterfaces.UserMainInfoRepositoryInterface

@Module
@InstallIn(ViewModelComponent::class)
abstract class UserInfoSectionRepositoryModule {

    @Binds
    abstract fun bindUserInfoSectionRepository (
        userInfoSectionRepositoryImpl: UserInfoSectionRepository
    ): UserInfoSectionRepositoryInterface
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class UserMainInfoRepositoryModule {

    @Binds
    abstract fun bindUserMainInfoRepository (
        userMainInfoRepositoryImpl: UserMainInfoRepository
    ): UserMainInfoRepositoryInterface
}