package com.example.virtualdecorar.data.remote.interceptor

import com.example.virtualdecorar.utils.constant.Constants
import com.example.virtualdecorar.BuildConfig
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

/**
 * Provides API [Authenticator] which can be used to make authenticated API calls.
 */
class ApiAuthenticator @Inject constructor() : Authenticator {

    private val apiKey = BuildConfig.SKETCHFAB_API_KEY

    override fun authenticate(route: Route?, response: Response): Request? {
        // If Authorization token isn't present then provide access
        // token.
        return if (response.request.headers[Constants.HEADER_AUTHORIZATION] == null) {
            response.request.newBuilder()
                .header(Constants.HEADER_AUTHORIZATION, "${Constants.TOKEN_KEY} $apiKey")
                .build()
        } else {
            null
        }
    }
}