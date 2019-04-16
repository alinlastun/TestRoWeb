package com.lam.testroweb.screen.detailsMovie.presenter

import com.lam.testroweb.model.DetailsMovie
import com.lam.testroweb.screen.detailsMovie.view.DetailsView


class DetailsPresenter(private var detailsView: DetailsView, private val detailsInteractor: DetailsInteractor):DetailsInteractor.OnFinishedListener  {
    override fun onResultSuccess(detailsMovie: DetailsMovie) {
        detailsView.getSuccessData(detailsMovie)
    }

    override fun onResultFail(strError: String) {
        detailsView.getErrorData(strError)
    }

    fun getDetailsMoieData() {
        detailsInteractor.requestDataAPI(this)
    }
}