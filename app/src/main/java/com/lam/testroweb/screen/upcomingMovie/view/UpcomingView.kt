package com.lam.testroweb.screen.upcomingMovie.view

import com.lam.testroweb.model.UpcomingModel

interface UpcomingView {
    fun getSuccessData(upcomingModel: UpcomingModel)
    fun getErrorData(strError: String)
}