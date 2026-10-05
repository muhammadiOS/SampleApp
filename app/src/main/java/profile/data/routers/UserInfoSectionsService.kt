package profile.data.routers

import profile.data.models.UserInfoSectionsModel
import retrofit2.http.GET

interface UserInfoSectionsService {
    @GET(" UserInfoSections")
    suspend fun get(userId: Int): UserInfoSectionsModel
}