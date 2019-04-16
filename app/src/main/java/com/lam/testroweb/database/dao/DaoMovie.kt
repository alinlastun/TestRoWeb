package com.lam.testroweb.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.lam.testroweb.database.model.UpcomingModelDB

@Dao
interface DaoMovie {
    @Query("select * from movie_table")
    fun getMovie():LiveData<MutableList<UpcomingModelDB>>

    @Query("select * from movie_table")
    fun getMovieList():MutableList<UpcomingModelDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieDB: UpcomingModelDB)

    @Query("delete from movie_table")
    fun deleteMovie()


}