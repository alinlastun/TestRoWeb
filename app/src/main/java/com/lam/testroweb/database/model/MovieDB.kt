package com.lam.testroweb.database.model

import android.arch.persistence.room.*
import com.lam.testroweb.database.GithubTypeConverters
import com.lam.testroweb.model.CreditMovie
import com.lam.testroweb.model.OverviewMovie
import com.lam.testroweb.model.UpcomingModel

@Entity(tableName = "movie_table")
@TypeConverters(GithubTypeConverters::class)
data class MovieDB(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    var uid: Int = -1,

    @Embedded(prefix = "upcoming_")
    var upcoming: UpcomingModel

)