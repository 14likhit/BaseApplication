package com.amotrade.baseapplication.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amotrade.baseapplication.data.repository.LocalRepository
import com.amotrade.baseapplication.viewmodel.MainViewModel
import java.lang.RuntimeException

class MainViewModelFactory(val localRepository: LocalRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(localRepository) as T
        } else {
            RuntimeException("error occured") as T
        }
    }

}