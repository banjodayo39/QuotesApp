package com.example.quotesapp.util.networkUtil

import android.accounts.AccountManager
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.quotesapp.util.LOG_TAG
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import java.io.IOException

class OkHttpClientAuthenticator(val context: Context) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}