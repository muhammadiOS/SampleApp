package profile.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import profile.domain.entities.UserInfoSectionEntity
import profile.domain.entities.UserMainInfoEntity
import profile.domain.usecases.GetUserInfoSectionsUseCase
import profile.domain.usecases.GetUserMainInfoUseCase
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserMainInfoUseCase: GetUserMainInfoUseCase,
    private val getUserInfoSectionsUseCase: GetUserInfoSectionsUseCase
) : ViewModel() {
    private var mainInfoStatus = MutableStateFlow<UIState<UserMainInfoEntity>>(UIState.Idle)
    private var userInfoSectionsStatus =
        MutableStateFlow<UIState<List<UserInfoSectionEntity>>>(UIState.Idle)

    fun getUserMainInfo(id: Int) {
        viewModelScope.launch {
            mainInfoStatus.emit(UIState.Loading)
            try {
                val entity = getUserMainInfoUseCase.execute(id)
                mainInfoStatus.emit(UIState.Success(entity))
            } catch (e: Exception) {
                mainInfoStatus.emit(UIState.Error(e.message ?: "some thing went wrong"))
            }
        }
    }

    fun getUserInfoSections(id: Int) {
        viewModelScope.launch {
            userInfoSectionsStatus.emit(UIState.Loading)
            try {
                val entity = getUserInfoSectionsUseCase.execute(id)
                userInfoSectionsStatus.emit(UIState.Success(entity))
            } catch (e: Exception) {
                userInfoSectionsStatus.emit(UIState.Error(e.message ?: "some thing went wrong"))
            }
        }
    }
}