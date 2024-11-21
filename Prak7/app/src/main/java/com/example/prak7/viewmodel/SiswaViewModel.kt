package com.example.prak7.viewmodel

import androidx.lifecycle.ViewModel
import com.example.prak7.model.DataSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {
    // Request
    private val _statusUI = MutableStateFlow(DataSiswa())

    // Response
    val statusUI: StateFlow<DataSiswa> = _statusUI.asStateFlow()

    fun saveDataSiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                NIM = ls[1],
                email = ls[2],
                notelp = ls[3],
                gender = ls[4],
                alamat = ls[5]
            )
        }
    }
}
