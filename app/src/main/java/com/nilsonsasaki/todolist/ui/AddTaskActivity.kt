package com.nilsonsasaki.todolist.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.nilsonsasaki.todolist.databinding.ActivityAddTaskBinding
import com.nilsonsasaki.todolist.datasource.TaskDataSource
import com.nilsonsasaki.todolist.extensions.format
import com.nilsonsasaki.todolist.extensions.text
import com.nilsonsasaki.todolist.model.Task
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners() {
        binding.dateTextField.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offset = timeZone.getOffset(Date().time) * -1
                binding.dateTextField.text = Date(it+ offset).format()
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }

        binding.timeTextField.editText?.setOnClickListener{
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setTitleText("Selecione um horário")
                .build()

            timePicker.addOnPositiveButtonClickListener {
                val timeText:String = if(timePicker.minute in 1..9) {
                    "${timePicker.hour}:0${timePicker.minute}"
                } else {"${timePicker.hour}:${timePicker.minute}"}
                binding.timeTextField.text = timeText
            }

            timePicker.show(supportFragmentManager, null)
        }

        binding.cancelButton.setOnClickListener {
            finish()
        }
        binding.createTaskButton.setOnClickListener {

        }
    }
}