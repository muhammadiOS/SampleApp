package profile.domain.repositoryInterfaces;

import profile.domain.entities.UserInfoSectionEntity;

interface UserInfoSectionRepositoryInterface {
    suspend fun getUserInfoSections(id: Int): List<UserInfoSectionEntity>
}
