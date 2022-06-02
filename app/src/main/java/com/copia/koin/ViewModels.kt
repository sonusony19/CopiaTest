package com.copia.koin

import com.copia.baseclasses.BaseViewModel
import com.copia.ui.launcher.viewmodel.LauncherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { BaseViewModel() }
    viewModel { LauncherViewModel() }
}