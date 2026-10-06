
package com.yourapp.profile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import profile.domain.entities.UserInfoSectionEntity
import profile.presentation.viewModels.ProfileGridViewModel
import profile.presentation.views.ProfileSectionCard

@Composable
fun ProfileGrid(
    onSectionClick: (UserInfoSectionEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    val sectionEntities: List<UserInfoSectionEntity> = emptyList()
    val viewModel: ProfileGridViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.getUserInfoSections()
    }

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
            items = sectionEntities,
            key = { it.id }
        ) { section ->

            ProfileSectionCard(
                section = section,
                onClick = {
                    onSectionClick(section)
                }
            )
        }
    }
}