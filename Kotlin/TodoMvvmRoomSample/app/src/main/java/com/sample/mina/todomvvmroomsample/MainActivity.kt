package com.sample.mina.todomvvmroomsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.sample.mina.todomvvmroomsample.database.NoteEntity
import com.sample.mina.todomvvmroomsample.ui.NotesAdapter
import com.sample.mina.todomvvmroomsample.view_models.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    var notesList = ArrayList<NoteEntity>()
    var notesAdapter: NotesAdapter? = null
    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initRecycler()
        initViewModel()

        fab.setOnClickListener { view ->
            val startEditorIntenet = Intent(this, EditorActivity::class.java)
            startActivity(startEditorIntenet)
        }
    }

    private fun initViewModel() {
        var notesObserver: Observer<List<NoteEntity>> = Observer {
            notesList.clear()
            notesList.addAll(it!!)
            if (notesAdapter == null) {
                notesAdapter = NotesAdapter(notesList, this)
                rcl_todos.adapter = notesAdapter
            } else {
                notesAdapter!!.notifyDataSetChanged()
            }


        }
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mViewModel.mNotes.observe(this, notesObserver)

    }

    /*
    method which initialize recycler view and configure it with layout manager
     */
    private fun initRecycler() {
        rcl_todos.setHasFixedSize(true)
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        rcl_todos.layoutManager = manager
        var mDividerItemDecoration = DividerItemDecoration(rcl_todos.context, manager.orientation)
        rcl_todos.addItemDecoration(mDividerItemDecoration)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_add_sample_data -> {
                addSampleData()
                true
            }
            R.id.action_delete_all_notes -> {
                deleteAllNotes()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteAllNotes() {
        mViewModel.deleteAllNotes()
    }

    private fun addSampleData() {
        mViewModel.addSampleData()
    }
}
