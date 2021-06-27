package com.hasanaydin.newsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.hasanaydin.newsapp.api.ArticlesData
import com.hasanaydin.newsapp.api.NewsData
import com.hasanaydin.newsapp.databinding.AdapterBinding

class Adapter(var dataList : List<ArticlesData>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder (val itemBinding : AdapterBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(articlesData: ArticlesData){
            itemBinding.title.text = articlesData.title
            itemBinding.textView.text = articlesData.description

            Glide.with(itemBinding.image.context)
                .load(articlesData.urlToImage)
                .into(itemBinding.image);
        }
    }

    lateinit var adapterLayout : AdapterBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        adapterLayout = AdapterBinding.inflate(LayoutInflater.from(parent.context))
        return (ViewHolder(adapterLayout))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return (dataList.size)
    }

}