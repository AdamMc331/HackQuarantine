package com.adammcneilly.hackquarantinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var tasks: MutableList<Task> = mutableListOf()
    private val adapter = TaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupButtonClick()
    }

    private fun setupButtonClick() {
        val inputEditText = findViewById<EditText>(R.id.task_input)
        val addButton = findViewById<Button>(R.id.add_button)

        addButton.setOnClickListener {
            val taskText = inputEditText.text.toString()
            addTask(taskText)

            inputEditText.setText("")
        }
    }

    private fun addTask(taskText: String) {
        val newTask = Task(description = taskText)
        tasks.add(newTask)

        adapter.tasks = tasks
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.task_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
