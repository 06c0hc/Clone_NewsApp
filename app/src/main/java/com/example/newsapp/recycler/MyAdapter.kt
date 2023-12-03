package com.example.newsapp.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.ItemMainBinding
import com.example.newsapp.model.ItemModel

//뷰 홀더
class MyViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

//어댑터
class MyAdapter(val context: Context, val datas: MutableList<ItemModel>?): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    //설명 : 리사이클러 뷰 목록에 표시되는 항목의 수
    override fun getItemCount(): Int{
        return datas?.size ?: 0
    }

    //설명 : 뷰 홀더를 준비
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    //설명 : 뷰 홀더의 뷰에 데이터를 출력
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding

        val model = datas!![position]
        binding.itemTitle.text = model.title
        binding.itemDesc.text = model.description
        binding.itemTime.text = "${model.author} At ${model.publishedAt}"
        Glide.with(context)
            .load(model.urlToImage)
            .into(binding.itemImage)
    }
}