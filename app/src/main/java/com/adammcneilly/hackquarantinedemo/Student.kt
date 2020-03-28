package com.adammcneilly.hackquarantinedemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val studentId: Long = 0,
    @ColumnInfo(name = "student_name")
    val studentName: String
)