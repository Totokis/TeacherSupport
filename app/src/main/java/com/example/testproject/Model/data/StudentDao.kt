package com.exampl

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testproject.Model.data.Student

@Dao
interface StudentDao {

    @Insert
    suspend fun addStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("DELETE FROM student_table")
    suspend fun deleteAllStudents()

    @Query("SELECT * FROM student_table ORDER BY id ASC")
    fun readAllData():LiveData<List<Student>>
}