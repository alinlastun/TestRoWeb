package com.lam.testroweb.screen.upcomingMovie.utils

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.lam.testroweb.screen.upcomingMovie.view.UpcominMoieAdapter


fun RecyclerView.setUpcomingInfoAdapter(){
    adapter = UpcominMoieAdapter()
    layoutManager = GridLayoutManager(context, 1)
}