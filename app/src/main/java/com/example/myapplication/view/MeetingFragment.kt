package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.StaticDataSource
import com.example.myapplication.databinding.FragmentMeetingBinding
import com.example.myapplication.view.adapter.CommentAdapter
import com.example.myapplication.view.adapter.ParticipantAdapter

private const val TOTAL_SPAN_COUNT = 2
private const val SPEAKER_SPAN_COUNT = 1
private const val PARTICIPANT_SPAN_COUNT = 1

class MeetingFragment : Fragment() {

    private var binding : FragmentMeetingBinding? = null
    private var participantAdapter: ParticipantAdapter? = null
    private var commentAdapter: CommentAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentMeetingBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        binding?.rvMeetingParticipants.run{
            participantAdapter = ParticipantAdapter()
            participantAdapter?.setParticipantData(StaticDataSource.dummyParticipants)
            this?.adapter = participantAdapter
            this?.layoutManager = getLayoutManager()
        }

        binding?.rvComments.run{
            commentAdapter = CommentAdapter()
            commentAdapter?.setCommentData(StaticDataSource.dummyComments)
            this?.adapter = commentAdapter
            this?.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun getLayoutManager() = GridLayoutManager(
        requireContext(),
        TOTAL_SPAN_COUNT,
        GridLayoutManager.HORIZONTAL,
        false
    ).apply {
        spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int) =
                if (position == 0) {
                    SPEAKER_SPAN_COUNT
                } else {
                    PARTICIPANT_SPAN_COUNT
                }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}