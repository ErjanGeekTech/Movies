package com.example.movies.data.db.converter

import androidx.room.TypeConverter
import com.example.movies.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private inline fun <reified T> typeToken() = object : TypeToken<T>() {}.type
    private inline fun <reified T> fromJson(value: String?) =
        Gson().fromJson<T>(value, typeToken<T>())

    private inline fun <reified T> toJson(generic: T) = Gson().toJson(generic, typeToken<T>())

    @TypeConverter
    fun fromImage(value: String?) = fromJson<Image?>(value)

    @TypeConverter
    fun imageToJson(image: Image?) = toJson(image)

    @TypeConverter
    fun fromLinks(value: String?) = fromJson<Links>(value)

    @TypeConverter
    fun linksToJson(links: Links?) = toJson(links)

    @TypeConverter
    fun fromRating(value: String?) = fromJson<Rating>(value)

    @TypeConverter
    fun ratingToJson(rating: Rating?) = toJson(rating)

    @TypeConverter
    fun fromNetwork(value: String?) = fromJson<Network>(value)

    @TypeConverter
    fun networkToJson(network: Network?) = toJson(network)

    @TypeConverter
    fun fromSchedule(value: String?) = fromJson<Schedule>(value)

    @TypeConverter
    fun scheduleToJson(schedule: Schedule) = toJson(schedule)

    @TypeConverter
    fun listFrom(value: String?) = fromJson<List<String>>(value)

    @TypeConverter
    fun listToJson(list: List<String>) = toJson(list)

    @TypeConverter
    fun fromExternals(value: String?) = fromJson<Externals>(value)

    @TypeConverter
    fun externalsToJson(externals: Externals) = toJson(externals)
}