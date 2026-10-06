package profile.data.routers

import retrofit2.http.Query
import profile.data.models.UserMainInfoModel
import retrofit2.http.GET

interface UserMainInfoService {

    @GET("user/main-info")
    suspend fun get(
        @Query("userId") userId: Int
    ): UserMainInfoModel
}