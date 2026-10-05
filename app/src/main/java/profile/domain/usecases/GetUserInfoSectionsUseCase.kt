package profile.domain.usecases

import profile.domain.entities.UserInfoSectionEntity
import profile.domain.repositoryInterfaces.UserInfoSectionRepositoryInterface
import javax.inject.Inject

class GetUserInfoSectionsUseCase @Inject constructor(
    private val userInfoSectionRepository: UserInfoSectionRepositoryInterface) {

    suspend fun execute(id: Int): List<UserInfoSectionEntity> {
        return userInfoSectionRepository.getUserInfoSections(id=id)
    }
}