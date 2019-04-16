package com.lam.testroweb.screen.upcomingMovie.presenter

import com.lam.testroweb.database.model.UpcomingModelDB
import com.lam.testroweb.screen.upcomingMovie.view.UpcomingView

class UpcomingPresenter(private var upcomingView: UpcomingView, private val upcomingInteractor: UpcomingInteractor):UpcomingInteractor.OnFinishedListener {
    override fun onResultSuccess(upcomingModel: UpcomingModelDB) {
        upcomingView.getSuccessData(upcomingModel)
    }

    override fun onResultFail(strError: String) {
        upcomingView.getErrorData(strError)
    }

    fun getNewsData() {
        upcomingInteractor.requestDataAPI(this)
    }
}