package com.example.studentmvvm.repository

import com.example.studentmvvm.data.StudentDao
import com.example.studentmvvm.model.Student
import kotlinx.coroutines.flow.Flow

class StudentRepository(private val studentDao: StudentDao) {

    // Nguồn chân lý duy nhất (Single Source of Truth)
    val allStudents: Flow<List<Student>> = studentDao.getAllStudents()

    suspend fun insert(student: Student) {
        studentDao.insertStudent(student)
    }

    suspend fun delete(student: Student) {
        studentDao.deleteStudent(student)
    }
}
