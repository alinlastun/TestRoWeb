package com.lam.testroweb.screen.upcomingMovie.presenter

import com.lam.testroweb.model.DetailsMovie

interface DetailsView {
    fun getSuccessData(detailsModel: DetailsMovie)
    fun getErrorData(strError: String)
}