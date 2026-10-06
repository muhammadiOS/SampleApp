
package com.yourapp.profile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import common.UIState
import profile.domain.entities.UserInfoSectionEntity
import profile.presentation.viewModels.ProfileGridViewModel
import profile.presentation.views.ProfileSectionCard


@Composable
fun ProfileGrid(
    onSectionClick: (UserInfoSectionEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel: ProfileGridViewModel = hiltViewModel()

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getUserInfoSections()
    }

    when (val currentState = state) {

        is UIState.Idle -> {
            // Nothing to display
        }

        is UIState.Loading -> {
            ProfileGridShimmer(
                modifier = modifier
            )
        }

        is UIState.Error -> {
            ProfileGridError(
                message = currentState.message,
                modifier = modifier
            )
        }

        is UIState.Success -> {
            ProfileGridContent(
                sections = currentState.response,
                onSectionClick = onSectionClick,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun ProfileGridContent(
    sections: List<UserInfoSectionEntity>,
    onSectionClick: (UserInfoSectionEntity) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier,
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 32.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(
            items = sections,
            key = { it.id }
        ) { section ->

            ProfileSectionCard(UIState.Success(response = section)) {
                onSectionClick(section)
            }
        }
    }
}

@Composable
private fun ProfileGridShimmer(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier,
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 32.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(6) {
            ProfileSectionCard(state = UIState.Loading, onClick = {})
        }
    }
}

@Composable
private fun ProfileGridError(
    message: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(32.dp),
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
                text = "Unable to load sections",
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