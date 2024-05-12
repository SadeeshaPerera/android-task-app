package com.example.tasker.ui._4home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tasker.data.DataManager
import com.example.tasker.data.db.entities.TaskList
import com.example.tasker.data.db.joinReturnTypes.TaskAndTaskList
import com.example.tasker.data.db.joinReturnTypes.TaskListAndCount
import com.example.tasker.data.network.Resource
import com.example.tasker.ui._0base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val dataManager: DataManager
) : BaseViewModel(dataManager) {

    var taskListAndCount = MutableLiveData<Resource<List<TaskListAndCount>>>()
    var taskAndTaskList = MutableLiveData<Resource<List<TaskAndTaskList>>>()
    var taskFinished = MutableLiveData<Long>()
    var taskDeleted = MutableLiveData<Long>()

    fun getData(todaysDateStart: Long, todaysDateEnd: Long) {

        viewModelScope.launch {
            dataManager.getTasksForToday(todaysDateStart, todaysDateEnd)
                .collect { tasksAndListFromDb: List<TaskAndTaskList> ->
                    if (tasksAndListFromDb.isNotEmpty())
                        taskAndTaskList.value = Resource.Success(tasksAndListFromDb)
                }
        }

        viewModelScope.launch {
            dataManager.getAllListsWithTaskCount()
                .collect { taskListsFromDb: List<TaskListAndCount> ->
                    if (taskListsFromDb.isNotEmpty())
                        taskListAndCount.value = Resource.Success(taskListsFromDb)
                }
        }
    }

    fun setTaskFinished(task: TaskAndTaskList) {
        viewModelScope.launch {
            if (task.finished != 1) {
                val count = dataManager.setTaskFinished(task.id)
                if (count > 0)
                    taskFinished.value = task.id
            }
        }
    }

    fun deleteTasK(task: TaskAndTaskList) {
        viewModelScope.launch {
            if (task.deleted != 1) {
                val count = dataManager.setTaskDeleted(task.id)
                if (count > 0)
                    taskDeleted.value = task.id
            }
        }
    }

    fun createNewList(listColor: String, listName: String) {
        viewModelScope.launch {
            insertTaskList(listName, listColor)
        }
    }

    private suspend fun insertTaskList(
        listName: String,
        listColor: String
    ) {
        val newTaskList: MutableList<TaskList> = arrayListOf()
        newTaskList.add(
            TaskList(
                0,
                listName,
                listColor
            )
        )
        dataManager.insertTaskLists(newTaskList)
    }
}
