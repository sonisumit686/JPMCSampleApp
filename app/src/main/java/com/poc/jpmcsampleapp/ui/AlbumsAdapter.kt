package com.poc.jpmcsampleapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.poc.jpmcsampleapp.data.model.Albums
import com.poc.jpmcsampleapp.databinding.ItemAlbumBinding


class AlbumsAdapter : ListAdapter<Albums, AlbumsAdapter.AlbumViewHolder>(AlbumDiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AlbumViewHolder(ItemAlbumBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.binding.album = getItem(position)
    }

    class AlbumViewHolder(val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root)
}

class AlbumDiffUtilCallBack : DiffUtil.ItemCallback<Albums>() {
    override fun areItemsTheSame(oldItem: Albums, newItem: Albums) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Albums, newItem: Albums) = oldItem == newItem
}