package com.lam.testroweb.screen.detailsMovie.presenter

import com.lam.testroweb.model.DetailsMovie
import com.lam.testroweb.repositorys.RepositoryUpcomingWS
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DetailsInteractor {
    private var mRepositoryWS = RepositoryUpcomingWS()

    interface OnFinishedListener {
        fun onResultSuccess(detailsMovie: DetailsMovie)
        fun onResultFail(strError: String)
    }

    fun requestDataAPI(onFinishedListener: DetailsInteractor.OnFinishedListener): Disposable {
        return mRepositoryWS.getInfoMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result -> onFinishedListener.onResultSuccess(result) },
                { error ->onFinishedListener.onResultFail(error.message!!)
                })
    }

}