package com.pss_dev.stockinvoice.presentation.screen.task

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.pss_dev.stockinvoice.data.MongoDB
import com.pss_dev.stockinvoice.domain.TaskAction
import com.pss_dev.stockinvoice.domain.ToDoTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(
    private val mongoDB: MongoDB
) : ScreenModel {

    fun setAction(action: TaskAction) {
        when (action) {
            is TaskAction.Add -> {
                addTask(action.task)
            }

            is TaskAction.Update -> {
                updateTask(action.task)
            }

            else -> {}
        }
    }

    private fun addTask(task: ToDoTask) {
        screenModelScope.launch(Dispatchers.Default) {
            mongoDB.addTask(task)
        }
    }

    private fun updateTask(task: ToDoTask) {
        screenModelScope.launch(Dispatchers.Default) {
            mongoDB.updateTask(task)
        }
    }
}