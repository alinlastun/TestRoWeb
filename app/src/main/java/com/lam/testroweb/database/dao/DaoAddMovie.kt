package com.lam.testroweb.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.lam.testroweb.database.model.AddMovieDB

@Dao
interface DaoAddMovie {
    @Query("select * from add_movie_table")
    fun getAddMovie():LiveData<MutableList<AddMovieDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAddMovie(movieDB: AddMovieDB)
}