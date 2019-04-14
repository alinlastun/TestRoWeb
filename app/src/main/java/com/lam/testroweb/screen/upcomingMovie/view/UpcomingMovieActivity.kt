package com.lam.testroweb.screen.upcomingMovie.view

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import com.lam.testroweb.databinding.ActivityMainBinding
import com.lam.testroweb.model.UpcomingModel
import com.lam.testroweb.screen.addMovie.AddMovieActivity
import com.lam.testroweb.screen.upcomingMovie.presenter.UpcomingInteractor
import com.lam.testroweb.screen.upcomingMovie.presenter.UpcomingPresenter
import com.lam.testroweb.screen.upcomingMovie.utils.setUpcomingInfoAdapter
import kotlinx.android.synthetic.main.activity_main.*


class UpcomingMovieActivity : AppCompatActivity(),UpcomingView {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var upcomingPresenter: UpcomingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mBinding = DataBindingUtil.setContentView(this, com.lam.testroweb.R.layout.activity_main)

        nRecylerViewUpComing.setUpcomingInfoAdapter()
        upcomingPresenter = UpcomingPresenter(this, UpcomingInteractor())
        nAddMovie.setOnClickListener {
            startActivity(Intent(this, AddMovieActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        upcomingPresenter.getNewsData()
    }

    override fun getSuccessData(upcomingModel: UpcomingModel) {
        (nRecylerViewUpComing.adapter as UpcominMoieAdapter).addUpcomingMovieInfo(upcomingModel.results)
    }

    override fun getErrorData(strError: String) {
        Log.d("eeasdfasd","getErrorData: ${strError}")
    }



}
