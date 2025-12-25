package com.example.questapi_100.view

import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailSiswaScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailSiswaViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiState = viewModel.uiStateDetail.collectAsState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiDetail.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToEditItem(uiState.value.detailSiswa.id) },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource(R.string.edit_siswa),
                )
            }
        },
    ) 