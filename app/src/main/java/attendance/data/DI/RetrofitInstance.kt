package attendance.data.DI

import attendance.data.repositoryImpls.AttendanceRepository
import attendance.data.routers.ApiService
import attendance.domain.repositoryInterfaces.AttendanceRepositoryInterface
import common.CurlInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
}


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAttendanceRepository (
        attendanceRepositoryImpl: AttendanceRepository
    ): AttendanceRepositoryInterface
}