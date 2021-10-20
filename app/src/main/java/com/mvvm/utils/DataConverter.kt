package com.mvvm.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mvvm.domain.entity.models.Photos



    @TypeConverter
    fun fromList(value: List<Photos>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Photos>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toList(value: String): List<Photos> {
        val gson = Gson()
        val type = object : TypeToken<List<Photos>>() {}.type
        return gson.fromJson(value, type)
    }
