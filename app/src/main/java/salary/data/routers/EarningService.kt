package salary.data.routers

import retrofit2.http.Query
import retrofit2.http.GET
import salary.data.models.EarningDTO

interface EarningService {

    @GET("user/earning")
    suspend fun get(
        @Query("userId") userId: Int
    ): EarningDTO
}