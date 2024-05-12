package com.example.tasker.ui._7finishedDeleted

import dagger.Module
import dagger.Provides

@Module
class FinishedDeletedTasksModule {

    @Provides
    fun provideDeletedFinishedTasksAdapter(): DeletedFinishedTasksAdapter {
        return DeletedFinishedTasksAdapter(arrayListOf())
    }
}