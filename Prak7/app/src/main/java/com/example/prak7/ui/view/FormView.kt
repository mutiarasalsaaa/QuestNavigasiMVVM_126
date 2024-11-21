package com.example.prak7.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FormView(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitClicked: (MutableList<String>) -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var notlp by remember { mutableStateOf("") }

    val listData: MutableList<String> = mutableListOf(nama, nim, email, notlp, gender, alamat)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text(text = "Nama") },
            placeholder = { Text(text = "Isi nama anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        TextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text(text = "NIM") },
            placeholder = { Text(text = "Isi NIM anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Isi email anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = notlp,
            onValueChange = { notlp = it },
            label = { Text(text = "No Telepon") },
            placeholder = { Text(text = "Isi nomor telepon anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        