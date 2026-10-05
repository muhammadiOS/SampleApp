package profile.data.mappers

import profile.data.models.UserMainInfoModel
import profile.domain.entities.UserMainInfoEntity

fun UserMainInfoModel.toEntity(): UserMainInfoEntity {
    return UserMainInfoEntity(
        imageUrl = this.imageUrl,
        name = this.name,
        jobTitle = this.title,
        status = this.status
    )
}