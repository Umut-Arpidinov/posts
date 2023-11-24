package com.example.sultanposts.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.sultanposts.util.Constants
import javax.inject.Inject

class Preference @Inject constructor(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)

    var id: String?
        set(value) = sharedPreferences.edit().putString(Constants.USER_ID, value).apply()
        get() = sharedPreferences.getString(Constants.USER_ID, null)
}