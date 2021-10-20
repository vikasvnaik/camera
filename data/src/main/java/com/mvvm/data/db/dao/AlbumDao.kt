package com.mvvm.data.db.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mvvm.data.db.entity.AlbumEntity

@Dao
interface AlbumDao {

    @Query("SELECT * FROM albums ORDER BY timeStamp ASC")
    suspend fun getAll(): List<AlbumEntity>

    @Insert
    suspend fun insert(vararg albumEntity: AlbumEntity)

    @Delete
    suspend fun delete(albumEntity: AlbumEntity)

    @Query("DELETE FROM albums WHERE id = :id")
    suspend fun deleteById(id: Long )
}