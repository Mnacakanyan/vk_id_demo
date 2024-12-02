package com.vk.vkiddemo.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vk.id.AccessToken

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    text: String,
    backendText: String,
    onUpdate: (String) -> Unit,
    onSuccessfulLogin: (AccessToken) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center
    ) {
        VkLoginButton(
            onLoginResult = onUpdate,
            onSuccessLogin = onSuccessfulLogin
        )
        SelectionContainer {
            Text(
                text = text,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = backendText
        )

    }
}