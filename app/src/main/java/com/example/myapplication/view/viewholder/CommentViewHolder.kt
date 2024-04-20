package com.example.myapplication.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.LayoutCommentItemBinding
import com.example.myapplication.databinding.LayoutParticipantViewBinding
import com.example.myapplication.model.Comment
import com.example.myapplication.model.Participant

class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = LayoutCommentItemBinding.bind(view)

    fun bind(comment: Comment){
        binding.imgCmtUser.setImageResource(comment.imageRes)
        binding.tvCmtUser.text = comment.name
        binding.tvCmtMsg.text = comment.message
    }

}