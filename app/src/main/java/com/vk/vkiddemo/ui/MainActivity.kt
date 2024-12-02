package com.vk.vkiddemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vk.id.VKID
import com.vk.vkiddemo.ui.composables.MainScreen
import com.vk.vkiddemo.ui.theme.VKIDDemoTheme
import com.vk.vkiddemo.ui.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        VKID.logsEnabled = true
        enableEdgeToEdge()
        setContent {

            val viewModel = koinViewModel<MainViewModel>()

            VKIDDemoTheme {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = 8.dp),
                        text = uiState.loginResultText,
                        backendText = uiState.backendResultText,
                        onUpdate = viewModel::updateText,
                        onSuccessfulLogin = viewModel::sendData
                    )
                }
            }
        }
    }
}

