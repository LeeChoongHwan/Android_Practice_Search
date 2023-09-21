package com.example.android_practice_search.bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_search.databinding.ItemSearchBinding
import com.example.android_practice_search.search.SearchModel

class BookmarkListAdapter() : RecyclerView.Adapter<BookmarkListAdapter.ViewHolder>() {

    private val list = ArrayList<SearchModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkListAdapter.ViewHolder {
        return ViewHolder(
            ItemSearchBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: BookmarkListAdapter.ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(private val binding : ItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: SearchModel) {

            }
        }
}