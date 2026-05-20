package common

import androidx.activity.ComponentActivity

sealed class NavigationEvents<out T> {
    data class navigateTo<T>(val response: T) : NavigationEvents<T>()
}