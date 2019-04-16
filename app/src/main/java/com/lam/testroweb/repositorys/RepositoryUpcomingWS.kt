package com.lam.testroweb.repositorys

import com.lam.testroweb.apiKey
import com.lam.testroweb.mMovieId
import com.lam.testroweb.model.CreditMovie
import com.lam.testroweb.model.DetailsMovie
import com.lam.testroweb.model.OverviewMovie
import com.lam.testroweb.model.UpcomingModel
import com.lam.testroweb.page
import com.lam.testroweb.retrofit.RetrofitService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class RepositoryUpcomingWS {

    fun getUpcomingMovie(): Observable<UpcomingModel> {
        return RetrofitService().getInstance().interfaces.getUpcomingMovies(apiKey,page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    private fun getOverview(): Observable<OverviewMovie> {
        return RetrofitService().getInstance().interfaces.getOverview(mMovieId,apiKey)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    private fun getCredits(): Observable<CreditMovie> {
        return RetrofitService().getInstance().interfaces.getCredits(mMovieId,apiKey)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun getInfoMovie(): Observable<DetailsMovie> {
        return Observable.zip(
            getOverview(),
            getCredits(),
            BiFunction<OverviewMovie, CreditMovie,  DetailsMovie> { res1, res2-> DetailsMovie(res1, res2)})
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

}