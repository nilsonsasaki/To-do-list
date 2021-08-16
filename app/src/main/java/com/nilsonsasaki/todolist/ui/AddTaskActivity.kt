package com.nilsonsasaki.todolist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.nilsonsasaki.todolist.databinding.ActivityAddTaskBinding
import com.nilsonsasaki.todolist.extensions.format
import com.nilsonsasaki.todolist.extensions.text
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
                fun timeText():String {
                    if(timePicker.minute<10){
                        return "${timePicker.hour} : 0${timePicker.minute}"
                    }
                    return "${timePicker.hour} : ${timePicker.minute}"
                }
                binding.timeTextField.text = timeText()
            }

            timePicker.show(supportFragmentManager, null)
        }
    }
}