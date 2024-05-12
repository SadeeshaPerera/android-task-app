package com.example.tasker.di.module

import com.example.tasker.ui._1splash.SplashActivity
import com.example.tasker.ui._1splash.SplashModule
import com.example.tasker.ui._4home.HomeActivity
import com.example.tasker.ui._4home.HomeModule
import com.example.tasker.ui._5newTask.NewTaskActivity
import com.example.tasker.ui._5newTask.NewTaskModule
import com.example.tasker.ui._6taskList.TasksActivity
import com.example.tasker.ui._6taskList.TasksModule
import com.example.tasker.ui._7finishedDeleted.FinishedDeletedTasksActivity
import com.example.tasker.ui._7finishedDeleted.FinishedDeletedTasksModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by vicky on 1/1/18.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [(SplashModule::class)])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [(HomeModule::class)])
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [(NewTaskModule::class)])
    abstract fun bindNewTaskActivity(): NewTaskActivity

    @ContributesAndroidInjector(modules = [(TasksModule::class)])
    abstract fun bindTasksActivity(): TasksActivity

    @ContributesAndroidInjector(modules = [(FinishedDeletedTasksModule::class)])
    abstract fun bindFinishedDeletedTasksActivity(): FinishedDeletedTasksActivity

}