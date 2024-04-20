package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.model.Comment
import com.example.myapplication.model.Participant
import com.example.myapplication.model.User

object StaticDataSource {

   val dummyParticipants = getParticipants()
   val dummyComments = getComments()
   val dummyUser = User("Esther Howard", "Host", R.drawable.dp7)

}

fun getParticipants() : List<Participant>{
    val participant1 = Participant("Garry", true, R.drawable.dp1)
    val participant2 = Participant("Smith", false, R.drawable.dp2)
    val participant3 = Participant("Tom", false, R.drawable.dp3)
    val participant4 = Participant("James", false, R.drawable.dp4)
    val participant5 = Participant("Adam", false, R.drawable.dp5)
    val participant6 = Participant("Mary", false, R.drawable.dp6)
    val participant7 = Participant("John", false, R.drawable.dp7)

    val participants = mutableListOf<Participant>()
    participants.add(participant1)
    participants.add(participant2)
    participants.add(participant3)
    participants.add(participant4)
    participants.add(participant5)
    participants.add(participant6)
    participants.add(participant7)

    return participants
}

fun getComments() : List<Comment>{

    val comment1 = Comment(R.drawable.comment5, "Garry", "Sent a gift to Adam")
    val comment2 = Comment(R.drawable.comment2, "Smith", "Sent a gift to John")
    val comment3 = Comment(R.drawable.comment7, "Mary", "Sent a gift to Steve")
    val comment4 = Comment(R.drawable.comment6, "Glenn", "Sent a gift to Elvis")

    val comments = mutableListOf<Comment>()

    comments.add(comment1)
    comments.add(comment2)
    comments.add(comment3)
    comments.add(comment4)

    return comments

}