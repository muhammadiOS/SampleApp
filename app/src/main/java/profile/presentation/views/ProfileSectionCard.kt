package profile.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import common.UIState
import common.shimmer
import profile.domain.entities.UserInfoSectionEntity

@Composable
fun ProfileSectionCard(
    state: UIState<UserInfoSectionEntity>,
    onClick: () -> Unit
) {
    when (state) {

        is UIState.Idle -> {
            // Nothing to show
        }

        is UIState.Loading -> {
            ProfileSectionShimmer()
        }

        is UIState.Error -> {
            ProfileSectionError(
                message = state.message
            )
        }

        is UIState.Success -> {
            ProfileSectionContent(
                section = state.response,
                onClick = onClick
            )
        }
    }
}

@Composable
private fun ProfileSectionContent(
    section: UserInfoSectionEntity,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(152.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFE5E7EB))
            .clickable {
                onClick()
            }
            .padding(22.dp)
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFF7F7F7)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = getSectionIcon(section.iconName),
                contentDescription = section.title,
                tint = Color.Gray,
                modifier = Modifier.size(30.dp)
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Text(
            text = section.title,
            color = Color(0xFF252B33),
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun ProfileSectionShimmer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(152.dp)
            .clip(RoundedCornerShape(8.dp))
            .shimmer()
            .background(Color.LightGray)
            .padding(22.dp)
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Box(
            modifier = Modifier
                .width(120.dp)
                .height(20.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.White)
        )
    }
}

@Composable
private fun ProfileSectionError(
    message: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(152.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFFFEBEE))
            .padding(22.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Something went wrong",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFB71C1C)
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = message,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

private fun getSectionIcon(iconName: String): ImageVector {
    return when (iconName) {
        "person" -> Icons.Outlined.Person
        "work" -> Icons.Outlined.Info
        "groups" -> Icons.Outlined.Warning
        "attendance" -> Icons.Outlined.Add
        "salary" -> Icons.Outlined.Build
        "benefits" -> Icons.Outlined.ThumbUp
        "achievements" -> Icons.Outlined.Settings
        else -> Icons.Outlined.Info
    }
}

@Preview(
    showBackground = true,
    //showSystemUi = true,
)
@Composable
private fun PreviewView() {
    ProfileSectionCard(state = UIState.Loading,
        onClick = {})
}