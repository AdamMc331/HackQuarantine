package com.adammcneilly.hackquarantinedemo

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

data class Address(
    val streetNumber: String,
    val streetName: String
)

@Entity(tableName = "students")
data class Student(
    @ColumnInfo(name = "student_name")
    val studentName: String,
    @PrimaryKey(autoGenerate = true)
    val studentId: Long = 0L,
    @Embedded(prefix = "address_")
    val address: Address
)

@Entity(
    foreignKeys = [ForeignKey(
        entity = Student::class,
        parentColumns = ["studentId"],
        childColumns = ["residentId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class DormRoom(
    val roomNumber: String,
    val residentId: Long
)