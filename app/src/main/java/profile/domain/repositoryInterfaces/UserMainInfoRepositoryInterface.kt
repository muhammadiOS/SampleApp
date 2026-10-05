package profile.domain.repositoryInterfaces

import profile.domain.entities.UserMainInfoEntity

interface UserMainInfoRepositoryInterface {
    suspend fun getUserMainInfo(id: Int): UserMainInfoEntity
}