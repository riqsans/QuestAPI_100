package com.example.questapi_100.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.questapi_100.repositori.AplikasiDataSiswa
import com.example.questapi_100.viewmodel.EntryViewModel
import com.example.questapi_100.viewmodel.HomeViewModel
import kotlinx.coroutines.channels.Channel
import okhttp3.Call

fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa)

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiDataSiswa().container.repositoryDataSiswa)
        }
        initializer {
            EntryViewModel(aplikasiDataSiswa().container.repositoryDataSiswa)
        }
    }
}
