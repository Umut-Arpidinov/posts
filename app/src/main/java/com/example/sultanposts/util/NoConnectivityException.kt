package com.example.sultanposts.util

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String?
        get() = "No Internet connection"
}