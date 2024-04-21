package com.example.myapplication.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.LayoutParticipantViewBinding
import com.example.myapplication.extensions.show
import com.example.myapplication.model.Participant

class ParticipantViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = LayoutParticipantViewBinding.bind(view)

    fun bind(participant: Participant){
        binding.imgParticipant.setImageResource(participant.imgRes)
        binding.txtSpeakerName.show(participant.isHost)
    }

}