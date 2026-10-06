package profile.presentation.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import profile.domain.entities.UserInfoSectionEntity
import profile.domain.usecases.GetUserInfoSectionsUseCase
import javax.inject.Inject

@HiltViewModel
class ProfileGridViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getUserInfoSectionsUseCase: GetUserInfoSectionsUseCase
) : ViewModel() {

    private val _userId: Int =
        checkNotNull(savedStateHandle["userId"])

    private var _state =
        MutableStateFlow<UIState<List<UserInfoSectionEntity>>>(UIState.Idle)
    val state = _state

    fun getUserInfoSections() {
        viewModelScope.launch {
            _state.emit(UIState.Loading)
            try {
                val entity = getUserInfoSectionsUseCase.execute(_userId)
                _state.emit(UIState.Success(entity))
            } catch (e: Exception) {
                _state.emit(UIState.Error(e.message ?: "some thing went wrong"))
            }
        }
    }
}