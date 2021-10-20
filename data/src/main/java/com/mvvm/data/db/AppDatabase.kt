package com.mvvm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mvvm.data.db.dao.AlbumDao
import com.mvvm.data.db.entity.AlbumEntity

@Database(entities = [AlbumEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationDao(): AlbumDao
}