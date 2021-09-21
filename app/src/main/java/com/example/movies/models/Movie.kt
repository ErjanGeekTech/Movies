package com.example.movies.models

import com.google.gson.annotations.SerializedName

data class Movie(
    val summary: String = "",
    val image: Image,
    val averageRuntime: Int = 0,
    @SerializedName("_links")
    val links: Links,
    val premiered: String = "",
    val rating: Rating,
    val runtime: Int = 0,
    val weight: Int = 0,
    val language: String = "",
    val type: String = "",
    val url: String = "",
    val officialSite: String = "",
    val network: Network,
    val schedule: Schedule,
    val genres: List<String>? = null,
    val name: String = "",
    val ended: String = "",
    val id: Int = 0,
    val externals: Externals,
    val updated: Int = 0,
    val status: String = ""
)