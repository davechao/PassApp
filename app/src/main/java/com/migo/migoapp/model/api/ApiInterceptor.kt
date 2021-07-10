package com.migo.migoapp.model.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.text.TextUtils
import com.migo.migoapp.model.emuns.ApiEnv
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Request
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor(val context: Context) : Interceptor {

    private var connectivityManager: ConnectivityManager? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        var apiEnv = ApiEnv.PUBLIC

        connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.let {
            it?.allNetworks?.forEach { network ->
                it.getNetworkCapabilities(network)?.let { capabilities ->
                    apiEnv = when {
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                            ApiEnv.PRIVATE
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                            ApiEnv.PRIVATE
                        }
                        else -> ApiEnv.PUBLIC
                    }
                }
            }
        }

        val request = chain.request()
        val newRequest = buildRequest(request, apiEnv)

        return chain.proceed(newRequest)
    }

    private fun buildRequest(request: Request, env: ApiEnv): Request {
        val newDomain = env.url
        val newHost = newDomain.toHttpUrlOrNull()?.host.toString()
        val requestBuilder = request.newBuilder()

        if (!TextUtils.isEmpty(newHost)) {
            val newUrl = request.url.newBuilder().host(newHost).build()
            requestBuilder.url(newUrl)
        }

        return requestBuilder.build()
    }
}