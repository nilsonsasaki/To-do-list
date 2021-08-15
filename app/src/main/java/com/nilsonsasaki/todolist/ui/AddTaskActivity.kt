package com.nilsonsasaki.todolist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nilsonsasaki.todolist.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}