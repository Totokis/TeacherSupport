package com.example.testproject.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.testproject.Model.data.Student
import com.example.testproject.Model.data.StudentDatabase
import com.example.testproject.Model.data.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) :AndroidViewModel(application) {

    val readAllData: LiveData<List<Student>>
    private val repository: StudentRepository

    init {
        val studentDao = StudentDatabase.getDatabase(application).studentDao()
        repository = StudentRepository(studentDao)
        readAllData = repository.readAllData
    }

    fun addStudent(student: Student){
        viewModelScope.launch(Dispatchers.IO){
            repository.addStudent(student)
        }
    }

    fun updateStudent(student: Student){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateStudent(student)
        }
    }

    fun deleteStudent(student: Student){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteStudent(student)
        }
    }

    fun deleteAllStudents(student: Student){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllStudents()
        }
    }
}