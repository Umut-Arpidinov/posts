package com.example.sultanposts.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class NetworkConnectionInterceptor
@Inject constructor(
    @ApplicationContext private val mContext: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isConnected()){
            throw NoConnectivityException()
        }
        val  builder = chain.request().newBuilder() as Request.Builder
        return chain.proceed(builder.build())

    }


    private fun isConnected(): Boolean {
        val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return (netInfo != null && netInfo.isConnectedOrConnecting)
    }

}