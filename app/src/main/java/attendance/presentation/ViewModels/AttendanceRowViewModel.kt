package attendance.presentation.ViewModels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class AttendanceRowViewModel  @Inject constructor() : ViewModel() {
    private val _navigation = MutableSharedFlow<AttendanceNavigationEvents>()
    val navigation = _navigation.asSharedFlow()

    fun onClick() {
        viewModelScope.launch {
            _navigation.emit(AttendanceNavigationEvents.OpenDetails)
        }
    }

}


sealed class AttendanceNavigationEvents {
    object OpenDetails: AttendanceNavigationEvents()
}