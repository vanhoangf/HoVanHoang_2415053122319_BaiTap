package com.example.studentmvvm.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.studentmvvm.databinding.DialogAddStudentBinding
import com.example.studentmvvm.model.Student
import com.example.studentmvvm.viewmodel.StudentViewModel

class AddStudentDialogFragment : DialogFragment() {

    private val viewModel: StudentViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogAddStudentBinding.inflate(LayoutInflater.from(requireContext()))

        return AlertDialog.Builder(requireContext())
            .setTitle("Thêm Sinh Viên Mới")
            .setView(binding.root)
            .setPositiveButton("Lưu") { _, _ ->
                val name = binding.etName.text.toString().trim()
                val code = binding.etCode.text.toString().trim()
                val email = binding.etEmail.text.toString().trim()
                val gpa = binding.etGpa.text.toString().toDoubleOrNull() ?: 0.0

                if (name.isNotEmpty() && code.isNotEmpty()) {
                    val student = Student(fullName = name, studentCode = code, email = email, gpa = gpa)
                    viewModel.insert(student)
                } else {
                    Toast.makeText(
                        requireContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT
                    ).show()
                }
            }
            .setNegativeButton("Hủy", null)
            .create()
    }
}
