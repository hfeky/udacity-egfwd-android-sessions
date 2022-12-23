/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.architecture.blueprints.todoapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import com.example.android.architecture.blueprints.todoapp.domain.*
import com.example.android.architecture.blueprints.todoapp.ui.addedittask.AddEditTaskViewModel
import com.example.android.architecture.blueprints.todoapp.ui.statistics.StatisticsViewModel
import com.example.android.architecture.blueprints.todoapp.ui.taskdetail.TaskDetailViewModel
import com.example.android.architecture.blueprints.todoapp.ui.tasks.TasksViewModel

/**
 * Factory for all ViewModels.
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val tasksRepository: TasksRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(StatisticsViewModel::class.java) ->
                        StatisticsViewModel(
                            GetTasksUseCase(tasksRepository)
                        )
                    isAssignableFrom(TaskDetailViewModel::class.java) ->
                        TaskDetailViewModel(
                            GetTaskUseCase(tasksRepository),
                            DeleteTaskUseCase(tasksRepository),
                            CompleteTaskUseCase(tasksRepository),
                            ActivateTaskUseCase(tasksRepository)
                        )
                    isAssignableFrom(AddEditTaskViewModel::class.java) ->
                        AddEditTaskViewModel(
                            GetTaskUseCase(tasksRepository),
                            SaveTaskUseCase(tasksRepository)
                        )
                    isAssignableFrom(TasksViewModel::class.java) ->
                        TasksViewModel(
                            GetTasksUseCase(tasksRepository),
                            ClearCompletedTasksUseCase(tasksRepository),
                            CompleteTaskUseCase(tasksRepository),
                            ActivateTaskUseCase(tasksRepository)
                        )
                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T
}
