package com.mvvm.ui.camera.fragments

import android.graphics.ImageFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mvvm.R
import com.mvvm.data.db.entity.AlbumEntity
import com.mvvm.databinding.FragmentAlbumBinding
import com.mvvm.databinding.FragmentPhotosBinding
import com.mvvm.extension.AppLayout
import com.mvvm.ui.base.BaseFragment
import com.mvvm.ui.camera.AlbumAdapter
import com.mvvm.ui.camera.PhotoAdapter
import com.mvvm.ui.camera.PhotoViewAdapter
import com.mvvm.utils.toList

class PhotosFragment : BaseFragment(AppLayout.fragment_photos) {

    private var _binding: FragmentPhotosBinding? = null
    private val binding get() = _binding!!
    private val args: PhotosFragmentArgs by navArgs()
    private val adapter by lazy {
        PhotoViewAdapter()
    }
    override fun onCreate(view: View) {
        binding.rv?.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = _binding ?: FragmentPhotosBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.submitList(toList((args.photos as AlbumEntity).photos))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}