package com.nilsonsasaki.todolist.model

data class Task(
    val title:String,
    val time: String,//renamed hour to time
    val date: String,
    val id: Int = 0
)
