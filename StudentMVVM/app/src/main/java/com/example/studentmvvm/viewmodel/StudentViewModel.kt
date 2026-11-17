package com.example.studentmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.studentmvvm.model.Student
import com.example.studentmvvm.repository.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: StudentRepository) : ViewModel() {

    // Chuyển đổi Flow từ Room sang LiveData để Fragment dễ dàng quan sát trên UI
    val allStudents: LiveData<List<Student>> = repository.allStudents.asLiveData(Dispatchers.IO)

    fun insert(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(student)
    }

    fun delete(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(student)
    }
}
