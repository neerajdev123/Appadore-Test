package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.data.StaticDataSource
import com.example.myapplication.databinding.FragmentMeetingBinding
import com.example.myapplication.view.adapter.ParticipantAdapter

private const val TOTAL_SPAN_COUNT = 2
private const val SPEAKER_SPAN_COUNT = 2
private const val PARTICIPANT_SPAN_COUNT = 1

/**
 * A simple [Fragment] subclass.
 * Use the [MeetingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MeetingFragment : Fragment() {

    private var binding : FragmentMeetingBinding? = null
    private var adapter: ParticipantAdapter? = null

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
        binding?.rvMeetingParticipiants.run{
            adapter = ParticipantAdapter()
            adapter?.setParticipantData(StaticDataSource.dummyParticipants)
            this?.adapter = adapter
            this?.layoutManager = getLayoutManager()
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
                if (StaticDataSource.dummyParticipants[position].isHost) {
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