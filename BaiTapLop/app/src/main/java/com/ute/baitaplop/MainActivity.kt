package com.ute.baitaplop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.baitaplop.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDetail.setOnClickListener {

            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra("name", "Hồ Văn Hoàng")
            intent.putExtra("studentId", "2415053122319")
            intent.putExtra("major", "Information Technology")
            intent.putExtra("gpa", 3.7)

            startActivity(intent)
        }
    }
}