package com.adammcneilly.hackquarantinedemo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDAO {
    @Insert
    fun insertStudent(student: Student): Long

    @Query("SELECT * FROM students")
    fun fetchAllStudents(): List<Student>

    @Update
    fun updateStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)
}