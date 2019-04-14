package com.lam.testroweb.screen.upcomingMovie.repositorys

import android.arch.lifecycle.MediatorLiveData
import com.lam.testroweb.apiKey
import com.lam.testroweb.model.UpcomingModel
import com.lam.testroweb.page
import com.lam.testroweb.retrofit.RetrofitService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryUpcomingWS {

    fun getUpcomingMovie(): Observable<UpcomingModel> {
        return RetrofitService().getInstance().interfaces.getUpcomingMovies(apiKey,page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun getDetails(): MediatorLiveData<FinalAddresses> {

        val mFinalAddresses = FinalAddresses()

        val mLiveDataMediator = MediatorLiveData<FinalAddresses>()
        mLiveDataMediator.addSource(getAddress()) { value -> if (value != null) addAddresses(mLiveDataMediator, mFinalAddresses, value) }
        mLiveDataMediator.addSource(getWsStatus()) { value -> if (value != null) addWsStatus(mLiveDataMediator, mFinalAddresses, value) }
        mLiveDataMediator.addSource(getSyncStatus()) { value -> if (value != null) addSyncStatus(mLiveDataMediator, mFinalAddresses, value) }
        return mLiveDataMediator
    }
}