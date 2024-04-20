package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.model.Participant

object StaticDataSource {

   val dummyParticipants = getParticipants()


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