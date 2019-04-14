package com.lam.testroweb.screen.addMovie

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.lam.testroweb.R
import kotlinx.android.synthetic.main.add_movie.*

class AddMovieActivity : AppCompatActivity() {
    private lateinit var mBinding: com.lam.testroweb.databinding.AddMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mBinding = DataBindingUtil.setContentView(this, R.layout.add_movie)

        nArrowLeft.setOnClickListener { onBackPressed() }

    }
}