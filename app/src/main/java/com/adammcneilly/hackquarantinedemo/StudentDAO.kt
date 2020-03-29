package com.adammcneilly.hackquarantinedemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDAO {
    @Insert
    fun insertStudent(student: Student): Long

    @Query("SELECT * FROM students")
    fun fetchAllStudents(): LiveData<List<Student>>

    @Query("SELECT * FROM students WHERE student_name = :name")
    fun fetchStudentsWithName(name: String): List<Student>

    @Update
    fun updateStudent(student: Student)
}