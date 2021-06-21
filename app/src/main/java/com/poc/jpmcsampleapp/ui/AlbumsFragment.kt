package com.poc.jpmcsampleapp.ui

import android.os.Bundle
import android.view.View
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.poc.jpmcsampleapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_albums.*

@AndroidEntryPoint
class AlbumsFragment : Fragment(R.layout.fragment_albums) {
    private val viewModels by viewModels<AlbumsViewModels>()
    private lateinit var albumAdapter: AlbumsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()

        viewModels.albumsReadOnly.observe(viewLifecycleOwner, {
            albumAdapter.submitList(it)
        })
    }

    private fun setUpRecyclerView() {
        albumAdapter = AlbumsAdapter()
        recycler_view.apply {
            adapter = albumAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}