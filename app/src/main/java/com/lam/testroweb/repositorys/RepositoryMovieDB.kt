package com.lam.testroweb.repositorys

import android.arch.lifecycle.LiveData
import android.content.Context
import android.os.AsyncTask
import com.lam.testroweb.database.AppDataBase
import com.lam.testroweb.database.model.UpcomingModelDB

class RepositoryMovieDB(mContext: Context) {
    private var appDB: AppDataBase = AppDataBase.getDataBase(mContext)

    fun getMovieFromDB() : LiveData<MutableList<UpcomingModelDB>> {
        return appDB.daoMovie().getMovie()
    }
    fun getMovieFromDBList() : MutableList<UpcomingModelDB> {
        return appDB.daoMovie().getMovieList()
    }
    fun insertMovieToDB(movieDB: UpcomingModelDB) {
        AddAsynTask(appDB).execute(movieDB)
    }

    fun deleteMovie(){
        appDB.daoMovie().deleteMovie()
    }

    class AddAsynTask(db: AppDataBase) : AsyncTask<UpcomingModelDB, Void, Void>() {
        private var deliveryAddressDB = db
        override fun doInBackground(vararg params: UpcomingModelDB): Void? {
            deliveryAddressDB.daoMovie().insertMovie(params[0])
            return null
        }
    }
}