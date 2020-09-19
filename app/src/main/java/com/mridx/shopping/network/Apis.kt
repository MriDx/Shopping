package com.mridx.shopping.network

import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest

interface Apis {

    fun getProducts(param : String) : Any? {
        return JsonObjectRequest(Request.Method.GET, "", null, {}, {})
    }

}