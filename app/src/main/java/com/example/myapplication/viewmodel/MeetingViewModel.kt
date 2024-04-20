package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Comment
import com.example.myapplication.model.Participant
import com.example.myapplication.repository.MeetingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MeetingViewModel @Inject constructor(
    private val repository: MeetingRepository
) : ViewModel() {

    fun getUserDetails() = repository.getUserDetails()

    fun getParticipantData() : List<Participant>{
        return repository.getParticipantList()
    }

    fun getCommentData() : List<Comment>{
        return repository.getCommentList()
    }

}