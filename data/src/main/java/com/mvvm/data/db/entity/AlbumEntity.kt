package com.mvvm.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mvvm.domain.entity.models.Photos
import org.json.JSONArray
import java.io.Serializable

@Entity(tableName = "albums")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long?,
    @ColumnInfo(name = "timeStamp") val timeStamp: String,
    @ColumnInfo(name = "photos")  val photos: String,
    @ColumnInfo(name = "desc") val desc: String
) : Serializable
