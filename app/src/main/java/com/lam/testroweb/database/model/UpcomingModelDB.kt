package com.lam.testroweb.database.model

import android.arch.persistence.room.*
import com.lam.testroweb.database.GithubTypeConverters
import com.lam.testroweb.model.UpcomingInfo
import java.util.*

@Entity(tableName = "movie_table",indices = [Index(value = ["page"], unique = true)])
@TypeConverters(GithubTypeConverters::class)
data class UpcomingModelDB(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    var uid: Int = -1,

    @ColumnInfo(name = "page")
    var page: Int = -1,

    @ColumnInfo(name = "results")
    var results:MutableList<UpcomingInfo> = ArrayList()

)