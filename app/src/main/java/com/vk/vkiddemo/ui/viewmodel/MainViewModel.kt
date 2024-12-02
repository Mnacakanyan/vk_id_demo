package com.vk.vkiddemo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.id.AccessToken
import com.vk.vkiddemo.domain.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val userRepository: UserRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = State()
        )

    fun updateText(text: String) {
        setState {
            copy(loginResultText = text)
        }
    }

    fun sendData(accessToken: AccessToken) {
        viewModelScope.launch {
            try{
                userRepository.sendUserData(
                    userIds = accessToken.userID,
                    accessToken = accessToken.token
                )
                setState {
                    copy(backendResultText = "Success")
                }
            }catch (_: Exception) {

            }
        }
    }

    private fun setState(block: State.() -> State) {
        _uiState.update(block)
    }

    data class State(
        val loginResultText: String = "",
        val backendResultText: String = ""
    )

}