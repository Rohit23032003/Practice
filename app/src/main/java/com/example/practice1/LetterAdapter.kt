package com.example.practice1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.practice1.databinding.FragmentLetterBinding

class LetterAdapter :RecyclerView.Adapter<LetterAdapter.viewHolder>() {
    class viewHolder(val view: View):RecyclerView.ViewHolder(view){
        val button:Button=view.findViewById(R.id.button)
    }

    private  val list=('A').rangeTo('Z').toList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):viewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item, parent, false)

        // Setup custom accessibility delegate to set the text read
        return viewHolder(layout)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = list.get(position)
        holder.button.text = item.toString()

//        // Assigns a [OnClickListener] to the button contained in the [ViewHolder]
        holder.button.setOnClickListener {
            // Create an action from WordList to DetailList
            // using the required arguments
            // Navigate using that action

            val action =letterDirections.actionLetterToWordTwo( letter= holder.button.text.toString())
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }}
