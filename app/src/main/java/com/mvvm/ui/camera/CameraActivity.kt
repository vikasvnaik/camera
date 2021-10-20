package com.mvvm.ui.camera

import android.os.Bundle
import android.view.View
import com.mvvm.databinding.ActivityCameraBinding
import com.mvvm.extension.viewBinding
import com.mvvm.ui.base.BaseAppCompatActivity
import com.mvvm.vm.camera.CameraVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class CameraActivity : BaseAppCompatActivity() {
    private val binding by viewBinding(ActivityCameraBinding::inflate)
    //private var binding  = ActivityCameraBinding.inflate(layoutInflater)
    private val cameraVM by viewModel<CameraVM>()

    //private lateinit var binding: ActivityCameraBinding
    override fun layout() = binding.root
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityCameraBinding.inflate(layoutInflater)
        //setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        // Before setting full screen flags, we must wait a bit to let UI settle; otherwise, we may
        // be trying to set app to immersive mode before it's ready and the flags do not stick
        binding.fragmentContainer.postDelayed({
            binding.fragmentContainer.systemUiVisibility = FLAGS_FULLSCREEN
        }, IMMERSIVE_FLAG_TIMEOUT)
    }

    companion object {
        /** Combination of all flags required to put activity into immersive mode */
        const val FLAGS_FULLSCREEN =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        /** Milliseconds used for UI animations */
        const val ANIMATION_FAST_MILLIS = 50L
        const val ANIMATION_SLOW_MILLIS = 100L
        private const val IMMERSIVE_FLAG_TIMEOUT = 500L
    }
}