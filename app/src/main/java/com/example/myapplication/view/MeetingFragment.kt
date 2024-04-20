package com.example.myapplication.view

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.StaticDataSource
import com.example.myapplication.databinding.FragmentMeetingBinding
import com.example.myapplication.view.adapter.CommentAdapter
import com.example.myapplication.view.adapter.ParticipantAdapter
import com.example.myapplication.viewmodel.MeetingViewModel


private const val TOTAL_SPAN_COUNT = 2
private const val SPEAKER_SPAN_COUNT = 1
private const val PARTICIPANT_SPAN_COUNT = 1

class MeetingFragment : Fragment() {

    private var binding : FragmentMeetingBinding? = null
    private var participantAdapter: ParticipantAdapter? = null
    private var commentAdapter: CommentAdapter? = null
    private val viewModel: MeetingViewModel by activityViewModels()

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

    override fun onResume() {
        super.onResume()
        binding?.videoView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding?.videoView?.onPause()
    }

    private fun init(){
        setUserData()
        initParticipantList()
        initCommentList()
        binding?.fab?.setOnClickListener { _ ->
            binding?.videoView?.visibility = View.VISIBLE
            val uri : Uri = Uri.parse("android.resource://" + context?.packageName + "/" + R.raw.video)
            binding?.videoView?.setVideoFromUri(context,uri)
            binding?.videoView?.setLooping(false)
            binding?.videoView?.setOnVideoEndedListener {
                binding?.videoView?.visibility = View.GONE
            }
        }
    }

    private fun setUserData(){
        //fetching user data from view model
        //synchronous flow as data is static, should be replaced by livedata/flow for asynchronous flow
        val userDetails = viewModel.getUserDetails()
        binding?.layoutHeader?.txtUserName?.text = userDetails.name
        binding?.layoutHeader?.txtRole?.text = userDetails.role
        binding?.layoutHeader?.imgProfile?.setImageResource(userDetails.profileUrl)
    }

    private fun initParticipantList() {
        binding?.rvMeetingParticipants.run {
            participantAdapter = ParticipantAdapter()
            //fetching participant data from view model
            //synchronous flow as data is static, should be replaced by livedata/flow for asynchronous flow
            participantAdapter?.setParticipantData(viewModel.getParticipantData())
            this?.adapter = participantAdapter
            this?.layoutManager = getLayoutManager()
        }
    }

    private fun initCommentList() {
        binding?.rvComments.run {
            commentAdapter = CommentAdapter()
            //fetching comment data from view model
            //synchronous flow as data is static, should be replaced by livedata/flow for asynchronous flow
            commentAdapter?.setCommentData(viewModel.getCommentData())
            this?.adapter = commentAdapter
            this?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
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