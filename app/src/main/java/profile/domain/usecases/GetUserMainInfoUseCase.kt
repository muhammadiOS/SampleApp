package profile.domain.usecases

import profile.domain.entities.UserMainInfoEntity
import profile.domain.repositoryInterfaces.UserMainInfoRepositoryInterface
import javax.inject.Inject


class GetUserMainInfoUseCase @Inject constructor(
    private val userMainInfoRepository: UserMainInfoRepositoryInterface) {
    suspend fun execute(id: Int): UserMainInfoEntity {
        return userMainInfoRepository.getUserMainInfo(id=id)
    }
}