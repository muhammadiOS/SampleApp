package salary.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import salary.domain.entities.EarningEntity
import salary.domain.usecase.GetEarningUseCase
import javax.inject.Inject

@HiltViewModel
class EarningViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getEarningUseCase: GetEarningUseCase
) : ViewModel() {

    private val _userId: Int =
        checkNotNull(savedStateHandle["userId"])

    private var _state =
        MutableStateFlow<UIState<EarningEntity>>(UIState.Idle)
    val state = _state

    fun getUserEarning() {
        viewModelScope.launch {
            _state.emit(UIState.Loading)
            try {
                val entity = getEarningUseCase.invoke(_userId)
                _state.emit(UIState.Success(entity))
            } catch (e: Exception) {
                _state.emit(UIState.Error(e.message ?: "some thing went wrong"))
            }
        }
    }
}