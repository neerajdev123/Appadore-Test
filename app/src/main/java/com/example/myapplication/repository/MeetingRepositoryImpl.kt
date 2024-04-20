package com.example.myapplication.repository

import com.example.myapplication.data.StaticDataSource
import com.example.myapplication.model.Comment
import com.example.myapplication.model.Participant
import com.example.myapplication.model.User
import javax.inject.Inject

class MeetingRepositoryImpl @Inject constructor(
    private val staticDataSource: StaticDataSource
) : MeetingRepository {
    override fun getUserDetails(): User {
        return staticDataSource.dummyUser
    }

    override fun getParticipantList(): List<Participant> {
        return staticDataSource.dummyParticipants
    }

    override fun getCommentList(): List<Comment> {
        return staticDataSource.dummyComments
    }
}