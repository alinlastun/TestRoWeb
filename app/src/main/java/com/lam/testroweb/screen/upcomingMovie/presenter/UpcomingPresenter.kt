package com.lam.testroweb.screen.upcomingMovie.presenter

import com.lam.testroweb.model.UpcomingModel
import com.lam.testroweb.screen.upcomingMovie.view.UpcomingView

class UpcomingPresenter(private var upcomingView: UpcomingView, private val upcomingInteractor: UpcomingInteractor):UpcomingInteractor.OnFinishedListener {
    override fun onResultSuccess(upcomingModel: UpcomingModel) {
        upcomingView.getSuccessData(upcomingModel)
    }

    override fun onResultFail(strError: String) {
        upcomingView.getErrorData(strError)
    }

    fun getNewsData() {
        upcomingInteractor.requestDataAPI(this)
    }
}