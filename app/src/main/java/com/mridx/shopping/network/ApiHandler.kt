package com.mridx.shopping.network

import android.content.Context
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

open class ApiHandler {

    var onResponse: (
        (success: Boolean, responseObj: JSONObject?, responseArr: JSONArray?) -> Unit)? = null

    private var instance: ApiHandler? = null


    fun getInstance(): ApiHandler {
        if (instance == null)
            instance = ApiHandler()
        return instance as ApiHandler
    }

    open fun getProducts(context: Context, param: JSONObject?) {
        val objectRequest = object : JsonObjectRequest(
            Method.GET,
            "https://jsonplaceholder.typicode.com/todos/1",
            param,
            { onResponse?.invoke(true, it, null) },
            { onResponse?.invoke(false, parseError(it), null) }
        ) {}
        VolleySingleTon.instance?.addToRequestQueue(objectRequest)
    }

    private fun parseError(error: VolleyError?): JSONObject? {
        if (error?.networkResponse != null && error.networkResponse.data != null) {
            return JSONObject(String(error.networkResponse.data))
        }
        return null
    }

}