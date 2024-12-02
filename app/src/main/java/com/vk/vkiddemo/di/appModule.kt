package com.vk.vkiddemo.di

import com.vk.vkiddemo.data.di.dataModule
import com.vk.vkiddemo.data.di.networkModule
import com.vk.vkiddemo.ui.di.viewModelModule

val appModule = viewModelModule + dataModule + networkModule