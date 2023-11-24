package com.example.sultanposts.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import com.example.sultanposts.R
import com.example.sultanposts.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.BuildConfig
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var bindingActivity: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivity.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHost
        val navController = navHostFragment.navController
        bindingActivity.bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            bindingActivity.bottomNav.visibility = View.VISIBLE
        }



        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }


    }
}
