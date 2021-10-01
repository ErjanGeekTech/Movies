package com.example.movies.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.models.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie ORDER BY id DESC")
    fun getStudents(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: List<Movie>)

    @Query("DELETE FROM movie")
    suspend fun clear()
}