package com.amotrade.baseapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amotrade.baseapplication.data.CakeMenu
import com.amotrade.baseapplication.data.repository.LocalRepository

class MainViewModel(val localRepository: LocalRepository) : ViewModel() {

    private var cakeMenuMutableLiveData = MutableLiveData<CakeMenu>()

    fun getCakeMenuLiveData(): LiveData<CakeMenu> {
        return cakeMenuMutableLiveData
    }

    fun getCakeMenuData() {
        cakeMenuMutableLiveData.value = localRepository.getCakeMenuData()
    }

}