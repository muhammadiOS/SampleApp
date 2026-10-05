package common

import attendance.data.routers.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import profile.data.routers.UserInfoSectionsService
import profile.data.routers.UserMainInfoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




@Module
@InstallIn(SingletonComponent::class)
object RetrofitInstance {

    private const val BASE_URL =
        "https://7acd3840-df50-42a7-90e1-e45d579550e2.mock.pstmn.io/"

    @Provides
    fun provideCurlInterceptor(): CurlInterceptor {
        return CurlInterceptor()
    }

    @Provides
    fun provideOkHttpClient(
        curlInterceptor: CurlInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(curlInterceptor)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)   // 🔥 THIS IS THE MISSING PIECE
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    fun userMainInfoService(retrofit: Retrofit): UserMainInfoService {
        return retrofit.create(UserMainInfoService::class.java)
    }

    @Provides
    fun userInfoSectionsService(retrofit: Retrofit): UserInfoSectionsService {
        return retrofit.create(UserInfoSectionsService::class.java)
    }

}


