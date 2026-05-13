package attendance.presentation.ViewModels
import androidx.lifecycle.ViewModel
import attendance.domain.entities.AttendanceEntity
import kotlinx.coroutines.*
import androidx.lifecycle.viewModelScope


import attendance.domain.usecases.AttendanceUseCase
import common.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class AttendanceViewModel  @Inject constructor(
    private val  attendanceUseCase: AttendanceUseCase) : ViewModel()  {

    private val _state = MutableStateFlow<UIState<AttendanceEntity>>(UIState.Idle)
    val state: StateFlow<UIState<AttendanceEntity>> = _state

     fun fetchUserAttendance() {
         viewModelScope.launch {
             _state.emit(UIState.Loading(true))
             try {
                 val entity = attendanceUseCase.getAttendance()
                 _state.emit(UIState.Success(entity))
             } catch (e: Exception) {
                 _state.emit(UIState.Error(e.message ?: "some thing went wrong"))
             } finally {
                 _state.emit(UIState.Loading(false))
             }
         }
    }
}