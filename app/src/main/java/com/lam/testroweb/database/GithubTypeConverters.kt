package com.lam.testroweb.database

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lam.testroweb.model.*
import java.util.*

class GithubTypeConverters {
    private var gson = Gson()

    @TypeConverter
    fun stringToUpcomingInfoList(data: String?): List<UpcomingInfo> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<UpcomingInfo>>() {

        }.type

        return gson.fromJson<List<UpcomingInfo>>(data, listType)
    }

    @TypeConverter
    fun upcomingInfoListToString(someObjects: List<UpcomingInfo>): String {
        return gson.toJson(someObjects)
    }

}