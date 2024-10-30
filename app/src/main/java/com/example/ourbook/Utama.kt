package com.example.ourbook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ourbook.databinding.ActivityMainBinding
import com.example.ourbook.databinding.ActivityUtamaBinding

class Utama: AppCompatActivity() {
    private lateinit var binding: ActivityUtamaBinding
    private lateinit var db: DatabaseHelper
    private lateinit var booksAdapter: BooksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUtamaBinding.inflate(layoutInflater)
        db = DatabaseHelper(this)
        booksAdapter = BooksAdapter(db.getAllBooks(), this)
        setContentView(binding.root)

        binding.booksRecyclearView.layoutManager = LinearLayoutManager(this)
        binding.booksRecyclearView.adapter = booksAdapter

        binding.addButton.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        binding.aboutButton.setOnClickListener{
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        booksAdapter.refreshData(db.getAllBooks())
    }
}