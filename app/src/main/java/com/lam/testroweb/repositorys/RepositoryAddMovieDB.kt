package com.lam.testroweb.repositorys

import android.arch.lifecycle.LiveData
import android.content.Context
import android.os.AsyncTask
import com.lam.testroweb.database.AppDataBase
import com.lam.testroweb.database.model.AddMovieDB

class RepositoryAddMovieDB(mContext: Context) {
    private var appDB: AppDataBase = AppDataBase.getDataBase(mContext)

    fun getAddMovieFromDB() : LiveData<MutableList<AddMovieDB>> {
        return appDB.daoAddMovie().getAddMovie()
    }
    fun addMOvieToDB(movieDB: AddMovieDB) {
        AddAsynTask(appDB).execute(movieDB)
    }

    class AddAsynTask(db: AppDataBase) : AsyncTask<AddMovieDB, Void, Void>() {
        private var deliveryAddressDB = db
        override fun doInBackground(vararg params: AddMovieDB): Void? {
            deliveryAddressDB.daoAddMovie().insertAddMovie(params[0])
            return null
        }
    }
}