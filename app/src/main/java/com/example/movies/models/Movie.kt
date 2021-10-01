package com.example.movies.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(
    @PrimaryKey
    val id: Int,
    val summary: String,
    val image: Image,
    val averageRuntime: Int,
    @SerializedName("_links")
    val links: Links,
    val premiered: String,
    val rating: Rating,
    val runtime: Int,
    val weight: Int,
    val language: String,
    val type: String,
    val url: String,
    val officialSite: String?,
    val network: Network?,
    val ended: String?,
    val schedule: Schedule,
    val genres: List<String>,
    val name: String,
    val externals: Externals,
    val updated: Int,
    val status: String
)