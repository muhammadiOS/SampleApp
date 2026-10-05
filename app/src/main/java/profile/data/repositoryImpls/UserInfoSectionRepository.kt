package profile.data.repositoryImpls

import attendance.data.mappers.toEntity
import profile.data.mappers.toEntity
import profile.data.routers.UserInfoSectionsService
import profile.domain.entities.UserInfoSectionEntity
import profile.domain.repositoryInterfaces.UserInfoSectionRepositoryInterface
import javax.inject.Inject


class UserInfoSectionRepository @Inject constructor(
    private val service: UserInfoSectionsService): UserInfoSectionRepositoryInterface {
    override suspend fun getUserInfoSections(id: Int): List<UserInfoSectionEntity> {
        return  service.get(id).toEntity()
    }
}