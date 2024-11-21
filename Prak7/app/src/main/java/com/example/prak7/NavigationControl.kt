package com.example.prak7

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.prak7.model.JenisKelamin
import com.example.prak7.model.JenisKelamin.listJK
import com.example.prak7.ui.view.FormView
import com.example.prak7.ui.view.TampilDataView
import com.example.prak7.viewmodel.SiswaViewModel

enum class Halaman{
    FORMULIR,
    TAMPILDATA
}

@Composable
fun NavigationControl(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    val context = LocalContext.current
    val uiState by viewModel.statusUI.collectAsState()

    NavHost(
        modifier = modifier.padding(16.dp),
        navController = navHost,
        startDestination = Halaman.FORMULIR.name
    ){
        composable(
            route = Halaman.FORMULIR.name
        ){
            FormView(
                listJK = listJK.map { id ->
                    context.getString(id)
                },
                onSubmitClicked = {
                    viewModel.saveDataSiswa(it)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                }
            )
        }
        composable(route = Halaman.TAMPILDATA.name){
            TampilDataView(uiState = uiState, onBackButton = {
                navHost.popBackStack()
            })
        }
    }
}