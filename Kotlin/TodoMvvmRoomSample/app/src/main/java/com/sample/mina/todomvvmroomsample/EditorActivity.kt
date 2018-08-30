package com.sample.mina.todomvvmroomsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.sample.mina.todomvvmroomsample.utilities.Constants
import com.sample.mina.todomvvmroomsample.view_models.EditorViewModel
import kotlinx.android.synthetic.main.activity_editor.*
import kotlinx.android.synthetic.main.content_editor.*

class EditorActivity : AppCompatActivity() {
    lateinit var mviewModel: EditorViewModel
    var mEditing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_check)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (savedInstanceState != null)
            mEditing = savedInstanceState.getBoolean(Constants.EDITING_KEY)
        initViewModel()
    }

    private var mNewNote: Boolean = false

    private fun initViewModel() {
        mviewModel = ViewModelProviders.of(this).get(EditorViewModel::class.java)
        mviewModel.mLiveNote.observe(this, Observer {
            if (!mEditing)
                edt_note.setText(it?.text)
        })
        var bundle = intent.extras
        if (bundle == null) {
            setTitle(getString(R.string.new_note))
            mNewNote = true
        } else {
            setTitle(getString(R.string.edit_note))
            var noteId = bundle.getInt(Constants.NOTE_ID_EXTRA)
            mviewModel.loadNoteById(noteId)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (!mNewNote)
            menuInflater.inflate(R.menu.menu_editor, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            saveAndReturn()
            true
        } else if (item?.itemId == R.id.action_delete) {
            mviewModel.deleteNote()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveAndReturn() {
        mviewModel.saveNote(edt_note.text.toString())
        finish()

    }

    override fun onBackPressed() {
        saveAndReturn()

        super.onBackPressed()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putBoolean(Constants.EDITING_KEY, true)
        super.onSaveInstanceState(outState)
    }
}
