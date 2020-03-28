package com.adammcneilly.hackquarantinedemo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Student::class],
    version = 1
)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDAO
}