package com.vk.vkiddemo.ui.composables

import android.util.Log
import androidx.compose.runtime.Composable
import com.vk.id.AccessToken
import com.vk.id.onetap.compose.onetap.OneTap

private const val TAG = "VKLogin"


@Composable
fun VkLoginButton(
    onLoginResult: (String) -> Unit,
    onSuccessLogin: (AccessToken) -> Unit
) {

    OneTap(
        onAuth = { _, accessToken ->
            val successInfoText = buildString {
                appendLine("Token: ${accessToken.token}")
                appendLine("IdToken: ${accessToken.idToken}")
                appendLine("UserID: ${accessToken.userID}")
                appendLine("ExpireTime: ${accessToken.expireTime}")
                appendLine("UserData: ${accessToken.userData}")
                appendLine("Scopes: ${accessToken.scopes}")
            }
            onLoginResult(successInfoText)
            onSuccessLogin(accessToken)
            Log.d(TAG, "VkLoginButton: success, data: $accessToken")
        },
        onFail = {_, error ->
            val failInfoText = buildString {
                append("Error: ${error.description}")
            }
            onLoginResult(failInfoText)
            Log.d(TAG, "VkLoginButton: fail, error: $error")
        },
    )
}