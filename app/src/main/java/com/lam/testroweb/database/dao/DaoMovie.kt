package com.lam.testroweb.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.lam.testroweb.database.model.MovieDB

@Dao
interface DaoMovie {
    @Query("select * from movie_table")
    fun getMovie():LiveData<MutableList<MovieDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieDB: MovieDB)
}