package attendance.presentation.ViewModels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject


@HiltViewModel
class AttendanceRowViewModel  @Inject constructor() : ViewModel() {
    private val _navigation = MutableSharedFlow<AttendanceNavigationEvents>()
    val navigation = _navigation.asSharedFlow()
    private val _userId = 8
    fun onClick() {
        viewModelScope.launch {
            _navigation.emit(AttendanceNavigationEvents.OpenDetails(_userId))
        }
    }

}


sealed class AttendanceNavigationEvents {
    data class OpenDetails(val userid: Int = 0): AttendanceNavigationEvents()
}