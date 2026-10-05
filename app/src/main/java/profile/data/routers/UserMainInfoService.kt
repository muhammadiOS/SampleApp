package profile.data.routers

import profile.data.models.UserMainInfoModel
import retrofit2.http.GET

interface UserMainInfoService {
    @GET("userMainInfo")
    suspend fun get(userId: Int): UserMainInfoModel
}