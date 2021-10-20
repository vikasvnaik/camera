package com.mvvm.ui.camera

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mvvm.databinding.ItemPhotoBinding
import com.mvvm.domain.entity.models.Photos
import com.mvvm.ui.base.BaseListAdapter
import com.mvvm.ui.base.DifCallback
import com.mvvm.ui.base.Holder
import com.transo.ken42.driver.extension.click


class PhotoAdapter : BaseListAdapter<Holder, Photos>(DifCallback()) {
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
        //binding.ivImage.setImageResource(item.path)
        Glide.with(binding.ivImage).load(item.path).into(binding.ivImage)
        /*binding.root.click {
            itemClickListener?.invoke(position, item)
        }*/
        binding.ivCross.click {
            itemClickListener?.invoke(position, item)
        }
    }
}