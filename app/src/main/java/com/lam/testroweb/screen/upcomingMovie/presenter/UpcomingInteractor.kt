package com.lam.testroweb.screen.upcomingMovie.presenter

import com.lam.testroweb.model.UpcomingModel
import com.lam.testroweb.repositorys.RepositoryUpcomingWS
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class UpcomingInteractor {
    private var mRepositoryWS = RepositoryUpcomingWS()
    interface OnFinishedListener {
        fun onResultSuccess(upcomingModel: UpcomingModel)
        fun onResultFail(strError: String)
    }

    fun requestDataAPI(onFinishedListener: OnFinishedListener): Disposable {
            return mRepositoryWS.getUpcomingMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result -> onFinishedListener.onResultSuccess(result) },
                    { error ->onFinishedListener.onResultFail(error.message!!)
                })
    }





}