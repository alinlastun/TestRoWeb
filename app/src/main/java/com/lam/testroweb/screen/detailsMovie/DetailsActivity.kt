package com.lam.testroweb.screen.detailsMovie

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.lam.testroweb.R

class DetailsActivity : AppCompatActivity() {

    private lateinit var mBinding: com.lam.testroweb.databinding.ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mBinding = DataBindingUtil.setContentView(this, com.lam.testroweb.R.layout.activity_details)

    }
}
