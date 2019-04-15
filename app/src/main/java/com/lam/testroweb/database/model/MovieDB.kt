package com.lam.testroweb.database.model

import android.arch.persistence.room.*

@Entity(tableName = "movie_table")
data class MovieDB(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id_")
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "overview")
    var overview:String
)
