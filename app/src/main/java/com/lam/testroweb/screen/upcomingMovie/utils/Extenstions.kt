package com.lam.testroweb.screen.upcomingMovie.utils

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.lam.testroweb.screen.upcomingMovie.view.UpcomingMovieActivity
import com.lam.testroweb.screen.upcomingMovie.view.UpcomingMovieAdapter


fun RecyclerView.setUpcomingInfoAdapter(upcomingActivity:UpcomingMovieActivity){
    adapter = UpcomingMovieAdapter(upcomingActivity)
    layoutManager = GridLayoutManager(context, 1)
}