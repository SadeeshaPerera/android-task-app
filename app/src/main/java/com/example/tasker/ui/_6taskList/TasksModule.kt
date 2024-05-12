package com.example.tasker.ui._6taskList

import dagger.Module
import dagger.Provides

@Module
class TasksModule {

    @Provides
    fun provideTasksForListAdapter(): TasksForListAdapter {
        return TasksForListAdapter(arrayListOf())
    }
}