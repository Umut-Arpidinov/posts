package com.example.sultanposts.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sultanposts.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.BuildConfig
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }


    }
}