package com.vk.vkiddemo.domain

interface UserRepository {
    suspend fun sendUserData(
        userIds: Long,
        accessToken: String
    )
}