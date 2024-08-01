package com.example.notez.repository

import androidx.lifecycle.LiveData
import com.example.notez.database.NoteDatabase
import com.example.notez.model.Note

class NoteRepository(private val noteDao: NoteDatabase) {

    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.update(note)
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return noteDao.getAllNotes()
    }

    fun searchNote(query: String?): LiveData<List<Note>> {
        return noteDao.searchNotes(query)
    }
}
