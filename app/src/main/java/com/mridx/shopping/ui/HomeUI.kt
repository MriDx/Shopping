package com.mridx.shopping.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mridx.shopping.R
import com.mridx.shopping.network.VolleySingleTon
import com.mridx.shopping.viewmodel.HomeUIViewModel
import kotlinx.android.synthetic.main.home_ui.*

class HomeUI : AppCompatActivity() {

    lateinit var viewModel: HomeUIViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_ui)


        viewModel = ViewModelProvider(this).get(HomeUIViewModel::class.java)

        viewModel.text.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })


        clickMe?.setOnClickListener { viewModel.changeValue(this) }

        viewModel.isLoading.observe(this, {
            if (it)
                progressBar?.visibility = View.VISIBLE
            else
                progressBar?.visibility = View.GONE
        })

    }


}