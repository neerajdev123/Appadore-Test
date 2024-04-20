package com.example.myapplication.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Comment
import com.example.myapplication.view.viewholder.CommentViewHolder

class CommentAdapter : RecyclerView.Adapter<CommentViewHolder>() {

    private val comments: MutableList<Comment> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CommentViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_comment_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(comments[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCommentData(commentData: List<Comment>) {
        comments.clear()
        comments.addAll(commentData)
        notifyDataSetChanged()
    }
}