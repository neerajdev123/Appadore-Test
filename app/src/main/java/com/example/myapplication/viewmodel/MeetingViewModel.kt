package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.StaticDataSource
import com.example.myapplication.model.Comment
import com.example.myapplication.model.Participant

class MeetingViewModel : ViewModel() {

    fun getUserDetails() = StaticDataSource.dummyUser

    fun getParticipantData() : List<Participant>{
        return StaticDataSource.dummyParticipants
    }

    fun getCommentData() : List<Comment>{
        return StaticDataSource.dummyComments
    }

}