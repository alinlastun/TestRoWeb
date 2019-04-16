package com.lam.testroweb.database.model

import android.arch.persistence.room.*

@Entity(tableName = "add_movie_table")
data class AddMovieDB(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id_")
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "overview")
    var overview:String

)
