package profile.data.routers

import profile.data.models.UserInfoSectionsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface UserInfoSectionsService {
    @GET("user/info-sections")
    suspend fun get(
        @Query("userId") userId: Int
    ): UserInfoSectionsModel
}

