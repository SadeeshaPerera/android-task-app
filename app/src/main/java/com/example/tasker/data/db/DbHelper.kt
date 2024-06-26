package com.example.tasker.data.db

import com.example.tasker.data.db.entities.TaskList
import com.example.tasker.data.db.entities.Task
import com.example.tasker.data.db.joinReturnTypes.TaskAndTaskList
import com.example.tasker.data.db.joinReturnTypes.TaskListAndCount
import kotlinx.coroutines.flow.Flow


interface DbHelper {

    fun getAllLists(): Flow<List<TaskList>>

    suspend fun getLists(): List<TaskList>

    fun getAllListsWithTaskCount(): Flow<List<TaskListAndCount>>

    suspend fun insertTaskLists(taskLists: List<TaskList>): List<Long>

    suspend fun insertTask(task: Task): Long

    suspend fun getTask(taskLongId: Long): Task

    fun getTasksForToday(todaysDateStart: Long, todaysDateEnd: Long): Flow<List<TaskAndTaskList>>

    suspend fun updateTask(task: Task): Int

    suspend fun insertTasks(tasksAndListFromServer: MutableList<Task>): List<Long>

    fun getTasksForList(listId: Long): Flow<List<Task>>

    suspend fun setTaskFinished(id: Long): Int

    suspend fun setTaskDeleted(id: Long): Int

    suspend fun updateTaskList(name: String, listId: Long): Int

    suspend fun getDeletedTasks(): List<TaskAndTaskList>

    suspend fun getFinishedTasks(): List<TaskAndTaskList>

    suspend fun setListDeleted(id: Long): Int

    suspend fun deleteListAndTasks(lisId: Long): Int
}
