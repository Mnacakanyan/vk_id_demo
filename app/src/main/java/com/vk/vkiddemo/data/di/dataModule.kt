package com.vk.vkiddemo.data.di

import com.vk.vkiddemo.data.repo.UserRepositoryImpl
import com.vk.vkiddemo.domain.UserRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::UserRepositoryImpl).bind(UserRepository::class)
}