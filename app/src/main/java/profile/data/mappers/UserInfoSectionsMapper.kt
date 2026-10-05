package profile.data.mappers

import profile.data.models.UserInfoSectionsModel
import profile.domain.entities.UserInfoSectionEntity

fun UserInfoSectionsModel.toEntity(): List<UserInfoSectionEntity> {
    return this.sections.map {
        UserInfoSectionEntity(
            title = it.title,
            iconName = it.iconName,
            order = it.order
        )
    }
}