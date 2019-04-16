package com.lam.testroweb.repositorys

import android.arch.lifecycle.LiveData
import android.content.Context
import android.os.AsyncTask
import com.lam.testroweb.database.AppDataBase
import com.lam.testroweb.database.model.MovieDB

class RepositoryMovieDB(mContext: Context) {
    private var appDB: AppDataBase = AppDataBase.getDataBase(mContext)

    fun getMovieFromDB() : LiveData<MutableList<MovieDB>> {
        return appDB.daoMovie().getMovie()
    }
    fun insertMovieToDB(movieDB: MovieDB) {
        AddAsynTask(appDB).execute(movieDB)
    }

    fun deteleMovie(){
        appDB.daoMovie().deleteMovie()
    }

    class AddAsynTask(db: AppDataBase) : AsyncTask<MovieDB, Void, Void>() {
        private var deliveryAddressDB = db
        override fun doInBackground(vararg params: MovieDB): Void? {
            deliveryAddressDB.daoMovie().insertMovie(params[0])
            return null
        }
    }
}