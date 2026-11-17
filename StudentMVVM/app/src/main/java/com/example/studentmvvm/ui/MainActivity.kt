package com.example.studentmvvm.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.studentmvvm.R
import com.example.studentmvvm.data.AppDatabase
import com.example.studentmvvm.repository.StudentRepository
import com.example.studentmvvm.viewmodel.StudentViewModel
import com.example.studentmvvm.viewmodel.StudentViewModelFactory

class MainActivity : AppCompatActivity() {

    // Khởi tạo Database Singleton và Repository ở tầng Host
    private val database by lazy { AppDatabase.getDatabase(this) }
    private val repository by lazy { StudentRepository(database.studentDao()) }

    private val viewModel: StudentViewModel by viewModels {
        StudentViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // QUAN TRỌNG: `by viewModels` là lazy. Phải truy cập ngay để ViewModel được tạo
        // bằng Factory và lưu vào ViewModelStore của Activity. Nếu không, Fragment gọi
        // activityViewModels() sẽ cố tạo StudentViewModel không tham số và bị crash.
        viewModel.toString()

        // MainActivity chỉ chứa FragmentContainerView nạp StudentListFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, StudentListFragment())
                .commit()
        }
    }
}
