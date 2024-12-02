package com.vk.vkiddemo.data.api

import com.vk.vkiddemo.data.model.AuthRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface WebApi {
    @POST("auth/vk")
    suspend fun sendUserData(
        @Body authRequest: AuthRequest
    )
}