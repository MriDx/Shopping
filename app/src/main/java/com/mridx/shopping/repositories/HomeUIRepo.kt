package com.mridx.shopping.repositories

import android.os.Handler
import java.util.*
import kotlin.random.Random

class HomeUIRepo {

    fun changeText() = Random(10)

    var x = 0

    fun changeOverTime(): String {
        x++
        return "Clicked $x times"
    }

}