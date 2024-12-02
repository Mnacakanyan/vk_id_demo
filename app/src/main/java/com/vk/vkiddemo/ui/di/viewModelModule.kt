package com.vk.vkiddemo.ui.di

import com.vk.vkiddemo.ui.viewmodel.MainViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MainViewModel)
}