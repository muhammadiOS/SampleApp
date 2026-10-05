package profile.domain.entities

data class UserInfoSectionEntity(
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