package common

sealed class UIState<out T> {
    data class Success<T>(val response: T) : UIState<T>()
    data class Error(val message: String): UIState<Nothing>()
    object Loading: UIState<Nothing>()
    object Idle: UIState<Nothing>()

}