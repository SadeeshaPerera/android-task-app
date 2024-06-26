package com.example.tasker.data.db.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Long,

    @ColumnInfo(name = "task")
    var task: String,

    @ColumnInfo(name = "date_time")
    var dateTime: Long,

    @ColumnInfo(name = "list_id")
    var listId: Long,

    @ColumnInfo(name = "finished")
    var finished: Int = 0,

    @ColumnInfo(name = "deleted")
    var deleted: Int = 0
)