package com.mvvm.ui.splash


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvvm.databinding.FragSplashBinding
import com.mvvm.extension.AppLayout
import com.mvvm.extension.startActivity
import com.mvvm.ui.base.BaseFragment
import com.mvvm.ui.camera.CameraActivity

class SplashFragment : BaseFragment(AppLayout.frag_splash) {

    private var _binding: FragSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(view: View) {
        Handler().postDelayed({
            startActivity<CameraActivity>()
            finish()
        }, 3000)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = _binding ?: FragSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}