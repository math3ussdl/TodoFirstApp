package com.adsap.todofirst.models.task

data class TaskResponse(
        val data : Task
)

data class TasksResponse(
        val data : List<Task>
)
