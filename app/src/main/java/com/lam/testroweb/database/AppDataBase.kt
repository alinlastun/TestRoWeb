package com.lam.testroweb.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.lam.testroweb.database.dao.DaoAddMovie
import com.lam.testroweb.database.dao.DaoMovie
import com.lam.testroweb.database.model.AddMovieDB
import com.lam.testroweb.database.model.MovieDB

@Database(entities = [(AddMovieDB::class),(MovieDB::class)], version = 1, exportSchema = false)

abstract class AppDataBase : RoomDatabase() {
    companion object {
        private var INSTANCE: AppDataBase? = null
        fun getDataBase(context: Context): AppDataBase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "data-db")
                    .allowMainThreadQueries().build()
            }
            return INSTANCE as AppDataBase
        }
    }

    abstract fun daoAddMovie() : DaoAddMovie
    abstract fun daoMovie() : DaoMovie
}