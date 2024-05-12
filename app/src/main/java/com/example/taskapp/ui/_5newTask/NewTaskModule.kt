package com.example.tasker.ui._5newTask

import dagger.Module
import dagger.Provides

@Module
class NewTaskModule {

    @Provides
    fun provideTaskListsAdapter2(): TaskListsAdapter2 {
        return TaskListsAdapter2(arrayListOf())
    }
}