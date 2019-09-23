package com.pessoadev.taskapp.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pessoadev.taskapp.R
import com.pessoadev.taskapp.model.Task
import kotlinx.android.synthetic.main.layout_task_list.view.*

class TaskAdapter :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    private val taskList: MutableList<Task> = mutableListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(task: Task) {
            itemView.textViewTask.text = task.task
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_task_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(taskList[position])

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setData(newTaskList : List<Task>) {
        taskList.clear()
        taskList.addAll(newTaskList)
        notifyDataSetChanged()
    }
}
