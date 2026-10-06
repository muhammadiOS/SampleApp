package profile.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.yourapp.profile.presentation.ProfileGrid
import profile.domain.entities.UserInfoSectionEntity

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onSectionClick: (UserInfoSectionEntity) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
    ) {

        ProfileHeader()

        ProfileGrid(onSectionClick = onSectionClick)
    }
}

@Preview(
    showBackground = true,
    //showSystemUi = true,
)
@Composable
private fun PreviewView() {
    ProfileScreen(){ }
}