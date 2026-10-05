package profile.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil3.compose.AsyncImage
import profile.domain.entities.UserMainInfoEntity

//import coil.compose.AsyncImage

@Composable
fun ProfileHeader(
    mainInfo: UserMainInfoEntity?,
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        /*
         * Top purple header
         */
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
                    icon = Icons.Outlined.Person
                )

                Spacer(
                    modifier = Modifier.width(10.dp)
                )

                HeaderActionButton(
                    icon = Icons.Outlined.Info
                )

                Spacer(
                    modifier = Modifier.width(10.dp)
                )

                HeaderActionButton(
                    icon = Icons.Outlined.Settings
                )
            }
        }

        /*
         * Profile information
         *
         * Avatar overlaps the purple header.
         */
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                //.background(color = Color(0xFF4B2001))
        ) {

            ProfileAvatar(
                imageUrl = mainInfo?.imageUrl,
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

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = mainInfo?.name.orEmpty(),
                        color = Color(0xFF252B33),
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                }

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = mainInfo?.name.orEmpty(),
                    color = Color(0xFF4C079B),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = mainInfo?.jobTitle.orEmpty(),
                    color = Color(0xFF94A0AA),
                    fontSize = 17.sp
                )
            }
        }
    }
}


/* ------------------------------------------------ */
/* Header Action Button                              */
/* ------------------------------------------------ */

@Composable
private fun HeaderActionButton(
    icon: ImageVector
) {

    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(
                Color.White.copy(alpha = 0.35f)
            ),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )
    }
}


/* ------------------------------------------------ */
/* Avatar                                            */
/* ------------------------------------------------ */

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
            .padding(5.dp)
    ) {

        AsyncImage(
            model = imageUrl,
            contentDescription = "Profile",
            modifier = Modifier
                .fillMaxWidth()
                .height(162.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun previewView() {
    ProfileHeader(
        mainInfo = UserMainInfoEntity.dummy()
    )
}


