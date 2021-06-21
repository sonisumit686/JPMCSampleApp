package com.poc.jpmcsampleapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poc.jpmcsampleapp.data.model.Albums
import com.poc.jpmcsampleapp.data.repository.DefaultAlbumRepository
import kotlinx.coroutines.launch


class AlbumsViewModels @ViewModelInject constructor(
    private val repository: DefaultAlbumRepository
) : ViewModel() {
    val albumsReadOnly: LiveData<List<Albums>>
        get() = repository.getAlbumsDB()

    init {
        getAlbums()
    }

    private fun getAlbums() = viewModelScope.launch {
        repository.getAlbums()
    }
}