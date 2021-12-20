package com.example.todoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.NoteItemBinding
import com.example.todoapp.model.Task

class NoteAdapter(var list: List<Task>, val onClick: (task:Task, position: Int) -> Unit): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: NoteItemBinding): RecyclerView.ViewHolder(binding.root){
        fun onBing(task: Task, position: Int){
            binding.note.text = task.note


            itemView.setOnClickListener {
                onClick(task, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBing(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}