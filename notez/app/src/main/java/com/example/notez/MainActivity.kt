package com.example.notez

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.notez.database.NoteDatabase
import com.example.notez.repository.NoteRepository
import com.example.notez.viewmodel.NoteViewModel
import com.example.notez.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    // Use by viewModels delegate for easy ViewModel initialization
    val noteViewModel: NoteViewModel by viewModels {
        NoteViewModelFactory(application, NoteRepository(NoteDatabase.invoke(this)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewModel is now ready to use
    }
}
