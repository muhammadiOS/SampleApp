package profile.data.models

import com.google.gson.annotations.SerializedName

data class UserInfoSectionsModel(
    @SerializedName("sections")
    val sections: List<SectionInfoDTO>,
)

data class SectionInfoDTO (
    @SerializedName("title")
    val title: String,

    @SerializedName("icon_name")
    val iconName: String,

    @SerializedName("order")
    val order: Int,
)