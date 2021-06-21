package com.poc.jpmcsampleapp.data.offline

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.poc.jpmcsampleapp.utils.BaseTestAlbums
import com.poc.jpmcsampleapp.utils.getValueForTestLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlbumDaoTest: BaseTestAlbums() {

    private lateinit var dao: AlbumDao
    private lateinit var database: AlbumDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AlbumDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.getAlbumDao()
    }

    @Test
    fun insertAlbumTestSuccess() {
        runBlockingTest {
            dao.insertAllAlbum(list)
        }
        assertThat(dao.getAlbums().getValueForTestLiveData()).isNotEmpty()
    }

    @Test
    fun saveAlbumValidationTest() {
        runBlockingTest {
            dao.insertAllAlbum(list)
        }
        assertThat(dao.getAlbums().getValueForTestLiveData()?.size).isEqualTo(list.size)
    }

    @Test
    fun clearAlbumValidationTest() {
        runBlockingTest {
            dao.insertAllAlbum(list)
            dao.clearAllAlbums()
        }
        assertThat(dao.getAlbums().getValueForTestLiveData()).isEmpty()
    }

    @After
    fun cleanup() {
        database.close()
    }
}