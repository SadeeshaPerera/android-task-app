package com.example.tasker.ui._7finishedDeleted

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tasker.data.DataManager
import com.example.tasker.data.db.joinReturnTypes.TaskAndTaskList
import com.example.tasker.ui._0base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class FinishedDeletedTasksViewModel @Inject constructor(
    private val dataManager: DataManager
) : BaseViewModel(dataManager) {

    var tasks = MutableLiveData<List<TaskAndTaskList>>()

    fun getDeletedTasks() {
        viewModelScope.launch {
            tasks.value = dataManager.getDeletedTasks()
        }
    }

    fun getFinishedTasks() {
        viewModelScope.launch {
            tasks.value = dataManager.getFinishedTasks()
        }
    }

}