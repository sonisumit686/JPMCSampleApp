package com.poc.jpmcsampleapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tb_albums")
data class Albums(
    @PrimaryKey
    val id: Int,
    val title: String,
    val userId: Int
)