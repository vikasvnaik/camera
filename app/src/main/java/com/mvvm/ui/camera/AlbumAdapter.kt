package com.mvvm.ui.camera

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mvvm.data.db.entity.AlbumEntity
import com.mvvm.databinding.ItemPhotoBinding
import com.mvvm.domain.entity.models.Album
import com.mvvm.domain.entity.models.Photos
import com.mvvm.ui.base.BaseListAdapter
import com.mvvm.ui.base.DifCallback
import com.mvvm.ui.base.Holder
import com.mvvm.utils.toList
import com.transo.ken42.driver.extension.click


class AlbumAdapter : BaseListAdapter<Holder, AlbumEntity>(DifCallback()) {
    private var clickIcon: ((Int, Int, Photos) -> Unit?)? = null
    override fun onCreateItemViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            ).root
        )
    }

    override fun onBindItemViewHolder(holder: Holder, position: Int) {
        val binding = ItemPhotoBinding.bind(holder.itemView)
        val item = getItem(position)
        Glide.with(binding.ivImage).load(toList(item.photos)[0].path).into(binding.ivImage)
        binding.root.click {
            itemClickListener?.invoke(position, item)
        }
    }
}