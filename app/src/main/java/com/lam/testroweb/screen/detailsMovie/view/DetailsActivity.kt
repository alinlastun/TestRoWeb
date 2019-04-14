package com.lam.testroweb.screen.detailsMovie.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.lam.testroweb.model.DetailsMovie
import com.lam.testroweb.screen.detailsMovie.presenter.DetailsInteractor
import com.lam.testroweb.screen.detailsMovie.presenter.DetailsPresenter
import com.lam.testroweb.screen.upcomingMovie.presenter.DetailsView

class DetailsActivity : AppCompatActivity(),DetailsView {


    private lateinit var mBinding: com.lam.testroweb.databinding.ActivityDetailsBinding
    private lateinit var detailsPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mBinding = DataBindingUtil.setContentView(this, com.lam.testroweb.R.layout.activity_details)

        detailsPresenter = DetailsPresenter(this, DetailsInteractor())

    }


    override fun onResume() {
        super.onResume()
        detailsPresenter.getNewsData()
    }

    override fun getSuccessData(detailsModel: DetailsMovie) {
        Log.d("qasdfasd","getSuccessData")
        Log.d("qasdfasd","overview: " + detailsModel.mOverviewMovie.overview)

    }

    override fun getErrorData(strError: String) {
        Log.d("qasdfasd","getErrorData: $strError")

    }
}
