package com.mridx.shopping.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mridx.shopping.repositories.HomeUIRepo

class HomeUIViewModel : ViewModel() {

    var repo: HomeUIRepo = HomeUIRepo()

    /* private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }*/

    private val _text = MutableLiveData<String>().apply { value = repo.changeOverTime() }

    fun changeValue() {
        _text.apply {
            value = repo.changeOverTime()
        }
    }

    val text: LiveData<String> = _text


}