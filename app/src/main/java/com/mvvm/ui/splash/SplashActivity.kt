package com.mvvm.ui.splash

import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import com.mvvm.databinding.ActivitySplashBinding
import com.mvvm.extension.*
import com.mvvm.ui.base.BaseAppCompatActivity
import com.mvvm.ui.camera.CameraActivity
import com.mvvm.ui.dashboard.DashboardActivity

class SplashActivity : BaseAppCompatActivity() {

    private val binding by viewBinding(ActivitySplashBinding::inflate)

    override fun layout() = binding.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

}