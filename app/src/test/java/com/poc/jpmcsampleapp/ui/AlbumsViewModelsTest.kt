package com.poc.jpmcsampleapp.ui

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.poc.jpmcsampleapp.data.repository.DefaultAlbumRepository
import com.poc.jpmcsampleapp.utils.BaseTestAlbumsApp
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class AlbumsViewModelsTest: BaseTestAlbumsApp() {

    private lateinit var viewModels: AlbumsViewModels
    @Mock
    private lateinit var repository: DefaultAlbumRepository

    @Before
    fun setUp() {
            viewModels = AlbumsViewModels(repository)
            albums.value = list
    }

    @Test
    fun validateRepositoryCall() = runBlockingTest {
        verify(repository, times(1)).getAlbums()
    }

    @Test
    fun getAlbumsListSucces() {
        whenever(viewModels.albumsReadOnly).thenReturn(albums)
        val result = viewModels.albumsReadOnly
        assertThat(result).isNotNull()
    }

    @Test
    fun getAlbumsListSuccesValidateSize() {
        whenever(viewModels.albumsReadOnly).thenReturn(albums)
        val result = viewModels.albumsReadOnly
        assertThat(result.value?.size).isEqualTo(list.size)
    }

    @Test
    fun getAlbumsListError() {
        whenever(viewModels.albumsReadOnly).thenReturn(null)
        val result = viewModels.albumsReadOnly
        assertThat(result).isNull()
    }
}