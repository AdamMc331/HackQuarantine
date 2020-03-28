package com.adammcneilly.hackquarantinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var students: MutableList<Student> = mutableListOf()
    private val adapter = StudentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupButtonClick()
    }

    private fun setupButtonClick() {
        val inputEditText = findViewById<EditText>(R.id.student_input)
        val addButton = findViewById<Button>(R.id.add_button)

        addButton.setOnClickListener {
            val studentName = inputEditText.text.toString()
            addStudent(studentName)

            inputEditText.setText("")
        }
    }

    private fun addStudent(studentName: String) {
        val newStudent = Student(studentName = studentName)
        students.add(newStudent)

        adapter.students = students
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.student_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
