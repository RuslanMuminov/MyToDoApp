package com.example.todoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.adapter.NoteAdapter
import com.example.todoapp.databinding.FragmentListBinding
import com.example.todoapp.model.Task
import com.example.todoapp.room.RoomDbHelper

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var roomDbHelper: RoomDbHelper
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        roomDbHelper = RoomDbHelper.DatabaseBuilder.getInstance(requireContext())


        setAdapter(roomDbHelper.roomDao().allTask())
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }

        return binding.root
    }

    private fun setAdapter(allTask: List<Task>){
        adapter = NoteAdapter(allTask){ it, position ->
            it
        }
        binding.rv.adapter = adapter
    }
}