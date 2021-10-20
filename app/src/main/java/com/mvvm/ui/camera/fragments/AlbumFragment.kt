package com.mvvm.ui.camera.fragments

import android.graphics.ImageFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import coil.api.load
import com.mvvm.R
import com.mvvm.data.db.DatabaseClient
import com.mvvm.data.db.dao.AlbumDao
import com.mvvm.databinding.FragmentAlbumBinding
import com.mvvm.databinding.FragmentDashboardBinding
import com.mvvm.extension.AppLayout
import com.mvvm.extension.EventObserver
import com.mvvm.extension.activityCompat
import com.mvvm.ui.base.BaseFragment
import com.mvvm.ui.camera.AlbumAdapter
import com.mvvm.ui.camera.PhotoAdapter
import com.mvvm.vm.OnWeatherUpdateEvent
import com.mvvm.vm.dashboard.DashboardVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class AlbumFragment : BaseFragment(AppLayout.fragment_album) {

    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy {
        AlbumAdapter()
    }
    override fun onCreate(view: View) {
        setUpRoomDb()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = _binding ?: FragmentAlbumBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //loadAlbums()
        binding.camFab.setOnClickListener {
            val directions = AlbumFragmentDirections.actionAlbumToCamera("0", ImageFormat.JPEG)
            navController.navigate(directions)
        }
        adapter.click { position, album_ ->
            val directions = AlbumFragmentDirections.actionAlbumToPhoto(album_)
            navController.navigate(directions)
        }

        adapter.clickIcon { position,album_ ->
            deleteAlbums(album_.id!!)
        }
    }

    override fun onResume() {
        super.onResume()
        loadAlbums()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private var albumDao: AlbumDao? = null
    private fun setUpRoomDb(){
        albumDao = DatabaseClient.getDatabase(requireContext()).locationDao()
        //locationDao = db.locationDao()
    }
    private fun loadAlbums(){
        binding.rv?.adapter = adapter
        GlobalScope.launch(Dispatchers.Main) {
            val albums = albumDao?.getAll() //Read data
            if (albums != null) {
                adapter.submitList(albums)
            }
        }
    }

    private fun deleteAlbums(id: Long){
        GlobalScope.launch(Dispatchers.Main) {
           albumDao?.deleteById(id)
            loadAlbums()
        }
    }

}