package com.pessoadev.taskapp.task

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pessoadev.taskapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_new_task.view.*
import org.koin.android.viewmodel.ext.android.viewModel


class TaskActivity : AppCompatActivity() {

    private val viewModel: TaskViewModel by viewModel()
    private lateinit var adapter : TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewTask.layoutManager = LinearLayoutManager(this)
        recyclerViewTask.adapter = TaskAdapter().apply { adapter = this }

        viewModel.loadTasks().also {
            progressBarTask.visibility = View.VISIBLE
        }

        viewModel.allTasks.observe(this, Observer { taskList ->
            adapter.setData(taskList)
            progressBarTask.visibility = View.INVISIBLE
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.task_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_new -> newTaskDialog()
        }
        return true
    }

    private fun newTaskDialog() {
        val layout = layoutInflater.inflate(R.layout.dialog_new_task, null)
        AlertDialog.Builder(this).setView(layout)
            .setPositiveButton("Create") { _, _ ->
                progressBarTask.visibility = View.VISIBLE
                viewModel.insertTask(layout.editTextTask.text.toString())
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            .create().show()

    }
}
