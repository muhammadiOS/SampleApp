package profile.domain.entities

data class UserMainInfoEntity(
    val imageUrl: String,
    val name: String,
    val jobTitle: String,
    val status: String
) {
    companion object {
        fun dummy(): UserMainInfoEntity {
            return UserMainInfoEntity(
                imageUrl = "",
                name = "Muhammad Abdelrahman",
                jobTitle = "Senior Android Developer",
                status = "Active"
            )
        }
    }
}