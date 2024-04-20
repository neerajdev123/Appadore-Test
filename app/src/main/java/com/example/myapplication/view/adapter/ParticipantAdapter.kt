package com.example.myapplication.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Participant
import com.example.myapplication.view.viewholder.ParticipantViewHolder

class ParticipantAdapter : RecyclerView.Adapter<ParticipantViewHolder>()  {

    private val participants: MutableList<Participant> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ParticipantViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_participant_view,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return participants.size
    }

    override fun onBindViewHolder(holder: ParticipantViewHolder, position: Int) {
        holder.bind(participants[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setParticipantData(deptSchedules: List<Participant>) {
        participants.clear()
        participants.addAll(deptSchedules)
        notifyDataSetChanged()
    }
}