package profile.domain.entities

import java.util.UUID

data class UserInfoSectionEntity(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val iconName: String,
    val order: Int
) {
    companion object {
        fun dummy(): UserInfoSectionEntity {
            return UserInfoSectionEntity(
                title = "Personal Info",
                iconName = "person",
                order = 1
            )
        }
    }
}