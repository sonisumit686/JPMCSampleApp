package com.poc.jpmcsampleapp.data.api

import com.poc.jpmcsampleapp.data.model.Albums
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {
    @GET("/albums")
    suspend fun getAllAlbum(): Response<List<Albums>>
}