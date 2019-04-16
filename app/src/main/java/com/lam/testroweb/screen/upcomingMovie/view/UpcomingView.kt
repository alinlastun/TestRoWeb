package com.lam.testroweb.screen.upcomingMovie.view

import com.lam.testroweb.database.model.UpcomingModelDB

interface UpcomingView {
    fun getSuccessData(upcomingModelDB: UpcomingModelDB)
    fun getErrorData(strError: String)
}