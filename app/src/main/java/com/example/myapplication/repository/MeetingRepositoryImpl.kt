package com.example.myapplication.repository

import com.example.myapplication.data.StaticDataSource
import com.example.myapplication.model.Comment
import com.example.myapplication.model.Participant
import com.example.myapplication.model.User

class MeetingRepositoryImpl : MeetingRepository {
    override fun getUserDetails(): User {
        return StaticDataSource.dummyUser
    }

    override fun getParticipantList(): List<Participant> {
        return StaticDataSource.dummyParticipants
    }

    override fun getCommentList(): List<Comment> {
        return StaticDataSource.dummyComments
    }
}