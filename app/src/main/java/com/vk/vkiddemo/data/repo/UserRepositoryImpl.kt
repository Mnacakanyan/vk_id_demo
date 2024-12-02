package com.vk.vkiddemo.data.repo

import com.vk.vkiddemo.data.api.WebApi
import com.vk.vkiddemo.data.model.AuthRequest
import com.vk.vkiddemo.domain.UserRepository

class UserRepositoryImpl(
    private val api: WebApi
) : UserRepository {
    override suspend fun sendUserData(userIds: Long, accessToken: String) {
        api.sendUserData(
            authRequest = AuthRequest(
                userIds = userIds,
                accessToken = accessToken
            )
        )
    }
}