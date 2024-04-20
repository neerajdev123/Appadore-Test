package com.example.myapplication.repository

import com.example.myapplication.model.Comment
import com.example.myapplication.model.Participant
import com.example.myapplication.model.User

interface MeetingRepository {

    fun getUserDetails() : User
    fun getParticipantList() : List<Participant>
    fun getCommentList() : List<Comment>

}