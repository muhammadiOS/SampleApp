package profile.data.repositoryImpls

import profile.data.mappers.toEntity
import profile.data.routers.UserMainInfoService
import profile.domain.entities.UserMainInfoEntity
import profile.domain.repositoryInterfaces.UserMainInfoRepositoryInterface
import javax.inject.Inject

class UserMainInfoRepository @Inject constructor(
    private val service: UserMainInfoService): UserMainInfoRepositoryInterface {
    override suspend fun getUserMainInfo(id: Int): UserMainInfoEntity {
        return  service.get(id).toEntity()
    }
}