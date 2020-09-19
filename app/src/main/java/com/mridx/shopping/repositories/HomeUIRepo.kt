package com.mridx.shopping.repositories

import android.content.Context
import android.os.Handler
import com.mridx.shopping.network.ApiHandler
import com.mridx.shopping.network.Apis
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

class HomeUIRepo : ApiHandler() {


    fun changeText() = Random(10)

    var x = 0

    fun changeOverTime(): String {
        x++
        return "Clicked $x times"
    }

    fun getData(param: String) {
        // TODO: 19/09/20 do query stuff
    }

    fun getProducts(context: Context, param: String) {
        super.getProducts(context, null)
    }



}