package common

sealed class UIState<out T> {
    data class Success<T>(val response: T) : UIState<T>()
    data class Error(val message: String): UIState<Nothing>()
    data class Loading<T>(val state: Boolean): UIState<T>()
    object Idle: UIState<Nothing>()

}