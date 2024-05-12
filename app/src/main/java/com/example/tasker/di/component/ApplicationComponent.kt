package com.example.tasker.di.component

import com.example.tasker.TaskerApplication
import com.example.tasker.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by vicky on 12/2/18.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(taskerApplication: TaskerApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(taskerApplication: TaskerApplication)
}