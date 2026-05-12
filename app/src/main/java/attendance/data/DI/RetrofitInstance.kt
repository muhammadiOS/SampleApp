package attendance.data.DI

import attendance.data.repositoryImpls.AttendanceRepository
import attendance.data.routers.ApiService
import attendance.domain.repositoryInterfaces.AttendanceRepositoryInterface
import attendance.presentation.ViewModels.AttendanceViewModel
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




@Module
object RetrofitInstance {
    private const val BASE_URL = "https://7acd3840-df50-42a7-90e1-e45d579550e2.mock.pstmn.io/"
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun provideApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}


@Module
class AttendanceRepoModule {
    @Provides
    fun provideAttendanceRepo(api: ApiService): AttendanceRepositoryInterface {
        return AttendanceRepository(api)
    }
}

@Component(modules = [RetrofitInstance::class, AttendanceRepoModule::class])
interface AppComponent {
    fun getAttendanceVM(): AttendanceViewModel
}