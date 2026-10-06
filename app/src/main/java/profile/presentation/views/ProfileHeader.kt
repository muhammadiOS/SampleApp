package profile.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import common.UIState
import common.shimmer
import profile.domain.entities.UserMainInfoEntity
import profile.presentation.viewModels.ProfileHeaderViewModel




@Composable
fun ProfileHeader(
    onPersonClick: () -> Unit = {},
    onInfoClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {
    val viewModel: ProfileHeaderViewModel = hiltViewModel()

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getUserMainInfo()
    }

    when (val currentState = state) {

        is UIState.Idle -> {
            // Nothing to display
        }

        is UIState.Loading -> {
            ProfileHeaderShimmer()
        }

        is UIState.Error -> {
            ProfileHeaderError(
                message = currentState.message
            )
        }

        is UIState.Success -> {
            ProfileHeaderContent(
                user = currentState.response,
                onPersonClick = onPersonClick,
                onInfoClick = onInfoClick,
                onSettingsClick = onSettingsClick
            )
        }
    }
}

@Composable
private fun ProfileHeaderContent(
    user: UserMainInfoEntity,
    onPersonClick: () -> Unit,
    onInfoClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        // Purple header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF4B20A8),
                            Color(0xFF25005B)
                        )
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 28.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(
                    modifier = Modifier.weight(1f)
                )

                HeaderActionButton(
                    icon = Icons.Outlined.Person,
                    onClick = onPersonClick
                )

                Spacer(
                    modifier = Modifier.width(10.dp)
                )

                HeaderActionButton(
                    icon = Icons.Outlined.Info,
                    onClick = onInfoClick
                )

                Spacer(
                    modifier = Modifier.width(10.dp)
                )

                HeaderActionButton(
                    icon = Icons.Outlined.Settings,
                    onClick = onSettingsClick
                )
            }
        }

        // Profile information
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
        ) {

            ProfileAvatar(
                imageUrl = user.imageUrl,
                modifier = Modifier
                    .padding(start = 18.dp)
                    .offset(y = (-102).dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 22.dp,
                        end = 16.dp,
                        top = 76.dp
                    )
            ) {

                Text(
                    text = user.name.orEmpty(),
                    color = Color(0xFF252B33),
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = user.name.orEmpty(),
                    color = Color(0xFF4C079B),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = user.jobTitle.orEmpty(),
                    color = Color(0xFF94A0AA),
                    fontSize = 17.sp
                )
            }
        }
    }
}


@Composable
private fun ProfileAvatar(
    imageUrl: String?,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(176.dp)
            .clip(CircleShape)
            .background(Color.White)
            .border(
                width = 4.dp,
                color = Color(0xFFFFD329),
                shape = CircleShape
            )
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Profile",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun HeaderActionButton(
    icon: ImageVector,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(
                Color.White.copy(alpha = 0.35f)
            )
            .clickable(
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(22.dp)
        )
    }
}

@Composable
private fun ProfileHeaderShimmer() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        // Purple header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF4B20A8),
                            Color(0xFF25005B)
                        )
                    )
                )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 28.dp
                    ),
                horizontalArrangement = Arrangement.End
            ) {

                repeat(3) {

                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(32.dp)
                            .clip(CircleShape)
                            .shimmer()
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
        ) {

            // Avatar skeleton
            Box(
                modifier = Modifier
                    .padding(start = 18.dp)
                    .offset(y = (-102).dp)
                    .size(176.dp)
                    .clip(CircleShape)
                    .shimmer()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 22.dp,
                        top = 76.dp
                    )
            ) {

                Box(
                    modifier = Modifier
                        .width(190.dp)
                        .height(32.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .shimmer()
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Box(
                    modifier = Modifier
                        .width(130.dp)
                        .height(22.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .shimmer()
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Box(
                    modifier = Modifier
                        .width(180.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .shimmer()
                )
            }
        }
    }
}

@Composable
private fun ProfileHeaderError(
    message: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(390.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                tint = Color(0xFFB71C1C),
                modifier = Modifier.size(40.dp)
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Unable to load profile",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = message,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun PreviewView() {
    ProfileHeaderError(message = "error")
}


