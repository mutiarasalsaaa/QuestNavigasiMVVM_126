package com.example.prak7.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prak7.model.DataSiswa

@Composable
fun TampilDataView(
    modifier: Modifier = Modifier,
    uiState: DataSiswa,
    onBackButton: () -> Unit
){
    Column(
        modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        TampilData(param = "Nama", argu = uiState.nama)
        TampilData(param = "Gender", argu = uiState.gender)
        TampilData(param = "Alamat", argu = uiState.alamat)
        TampilData(param = "nim", argu = uiState.NIM)
        TampilData(param = "email", argu = uiState.email)
        TampilData(param = "notelp", argu = uiState.notelp)


        Button(onClick = onBackButton) {
            Text(text = "Kembali")
        }
    }
}

