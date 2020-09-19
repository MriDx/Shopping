package com.mridx.shopping.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySignle {
    private VolleySignle instance;
    private RequestQueue requestQueue;

    public VolleySignle(Context context) {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
    }

    public VolleySignle getInstance(Context context) {
        if (instance == null) {
            instance = new VolleySignle(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) throw new IllegalArgumentException("Init failed");
        return requestQueue;
    }
}
