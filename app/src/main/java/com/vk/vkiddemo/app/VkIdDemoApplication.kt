package com.vk.vkiddemo.app

import android.app.Application
import com.vk.id.VKID
import com.vk.vkiddemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VkIdDemoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        VKID.init(this)
        startKoin {
            androidContext(this@VkIdDemoApplication)
            modules(appModule)
        }
    }
}