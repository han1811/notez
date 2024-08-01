package com.example.notez.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notez.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes WHERE noteTitle LIKE '%' || :query || '%' OR noteDesc LIKE '%' || :query || '%'")
    fun searchNotes(query: String?): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note): Long

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Note>>
}
