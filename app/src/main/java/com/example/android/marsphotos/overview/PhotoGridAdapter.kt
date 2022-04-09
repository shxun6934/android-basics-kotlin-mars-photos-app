package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

class PhotoGridAdapter :
    ListAdapter<MarsPhoto, PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {

        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        return MarsPhotoViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo)
    }

    class MarsPhotoViewHolder(private val binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: MarsPhoto) {
            binding.photo = photo
            binding.executePendingBindings()
        }
    }
}