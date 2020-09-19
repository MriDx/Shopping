package com.mridx.shopping.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.toolbox.JsonObjectRequest
import com.mridx.shopping.network.ApiHandler
import com.mridx.shopping.network.VolleySingleTon
import com.mridx.shopping.repositories.HomeUIRepo
import org.json.JSONArray
import org.json.JSONObject
import kotlin.coroutines.coroutineContext

class HomeUIViewModel : ViewModel() {

    var repo: HomeUIRepo = HomeUIRepo()

    init {
        repo.onResponse = this::invoke
    }

    private val _text = MutableLiveData<String>().apply { value = repo.changeOverTime() }
    private val _isLoading: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().apply { value = false }


    fun changeValue(context: Context) {
        _isLoading.apply { value = true }
        repo.getProducts(context, null)
    }

    val text: LiveData<String> = _text
    val isLoading : LiveData<Boolean> = _isLoading


    fun invoke(success: Boolean, responseObj: JSONObject?, responseArr: JSONArray?) {
        _isLoading.apply { value = false }
        if (success) {
            _text.apply { value = responseObj?.getString("title") }
            return
        }
        _text.apply { value = "Failed" }
    }


}