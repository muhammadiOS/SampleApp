package profile.data.models

import com.google.gson.annotations.SerializedName

data class UserMainInfoModel(

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("status")
    val status: String,
)
