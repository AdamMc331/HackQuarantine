package com.adammcneilly.hackquarantinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    private val adapter = StudentAdapter()

    private val database: StudentDatabase by lazy {
        Room.databaseBuilder(
            this,
            StudentDatabase::class.java,
            "student-database.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupButtonClick()

        database.studentDao().fetchAllStudents().observe(this, Observer { students ->
            adapter.students = students
        })
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

        val insertRunnable = Runnable {
            database.studentDao().insertStudent(newStudent)
        }

        val thread = Thread(insertRunnable)

        thread.start()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.student_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
