package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.StaticDataSource
import com.example.myapplication.model.Comment
import com.example.myapplication.model.Participant
import com.example.myapplication.repository.MeetingRepository
import com.example.myapplication.repository.MeetingRepositoryImpl

class MeetingViewModel : ViewModel() {

    private val repository : MeetingRepository = MeetingRepositoryImpl()

    fun getUserDetails() = repository.getUserDetails()

    fun getParticipantData() : List<Participant>{
        return repository.getParticipantList()
    }

    fun getCommentData() : List<Comment>{
        return repository.getCommentList()
    }

}