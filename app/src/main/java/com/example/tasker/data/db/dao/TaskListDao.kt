package com.example.tasker.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.tasker.data.db.entities.TaskList
import com.example.tasker.data.db.joinReturnTypes.TaskListAndCount
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskListDao {

    @Query("SELECT * FROM lists")
    fun getAllLists(): Flow<List<TaskList>>

    @Query("SELECT * FROM lists WHERE deleted != 1")
    suspend fun getLists(): List<TaskList>

    @Query(
        """
        SELECT 
            l.id, l.name, l.color , 
            (
                SELECT COUNT(*)
                FROM tasks t
                WHERE t.list_id = l.id AND t.finished != 1 AND t.deleted != 1 
            ) AS task_count
        FROM lists l WHERE l.deleted != 1;
        """
    )
    fun getAllListsWithTaskCount(): Flow<List<TaskListAndCount>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskLists(taskLists: List<TaskList>): List<Long>

    @Query("UPDATE lists SET name=:name WHERE id=:listId")
    suspend fun updateTaskList(name: String, listId: Long): Int

    @Query("UPDATE lists SET deleted = 1 WHERE id =:id")
    suspend fun setListDeleted(id: Long): Int

    @Query("UPDATE tasks SET deleted = 1 WHERE list_id =:listId")
    suspend fun setTaskDeletedFromList(listId: Long): Int

    @Transaction
    suspend fun deleteListAndTasks(listId: Long): Int {
        if (setListDeleted(listId) > 0) {
            if (setTaskDeletedFromList(listId) > 0) {
                return 1
            } else {
                return 0
            }
        } else {
            return 0
        }
    }
}