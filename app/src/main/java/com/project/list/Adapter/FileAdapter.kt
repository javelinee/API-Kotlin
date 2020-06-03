package com.project.list.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.list.Data.BookData
import com.project.list.R

class FileAdapter(val context : Context, var data : List<BookData>) : RecyclerView.Adapter<FileAdapter.MyViewHolder>()  {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.image)
        val author : TextView = itemView.findViewById(R.id.author_name)
        val name : TextView = itemView.findViewById(R.id.book_name)
        val desc : TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(data.get(position).avatar).into(holder.image)

        holder.author.text = data.get(position).author
        holder.name.text = data.get(position).name
        holder.desc.text = data.get(position).description
    }

    fun setBook(bookList : List<BookData>){
        this.data = bookList
        notifyDataSetChanged()
    }

}