package com.example.android_practice_search.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_search.databinding.ItemSearchBinding

class SearchListAdapter : RecyclerView.Adapter<SearchListAdapter.ViewHolder>() {

    private val list = ArrayList<SearchModel>()

    fun addItems(items : List<SearchModel>) {
        list.addAll(items)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchListAdapter.ViewHolder {
        return ViewHolder(
            ItemSearchBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: SearchListAdapter.ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(private val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : SearchModel) {
            binding.imageText.text = item.type
            binding.titleText.text = item.title
            binding.dateText.text = item.date
        }
    }
}