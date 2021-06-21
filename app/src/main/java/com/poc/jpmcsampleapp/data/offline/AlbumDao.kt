package com.poc.jpmcsampleapp.data.offline

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poc.jpmcsampleapp.data.model.Albums

@Dao
interface AlbumDao {

    @Query("Select * from tb_albums ORDER BY title")
    fun getAlbums(): LiveData<List<Albums>>

    @Query("delete from tb_albums")
    suspend fun clearAllAlbums()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllAlbum(albums: List<Albums>)

}