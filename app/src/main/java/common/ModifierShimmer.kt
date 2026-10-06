package common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Modifier.shimmer(): Modifier = composed {

    val transition = rememberInfiniteTransition(
        label = "shimmer"
    )

    val translateX = transition.animateFloat(
        initialValue = -500f,
        targetValue = 500f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer_translate"
    )

    val shimmerBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFE5E7EB),
            Color(0xFFF7F7F7),
            Color(0xFFE5E7EB)
        ),
        start = Offset(
            x = translateX.value,
            y = 0f
        ),
        end = Offset(
            x = translateX.value + 200f,
            y = 0f
        )
    )

    background(shimmerBrush)
}