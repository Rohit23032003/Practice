package com.example.practice1

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.practice1.word.Companion.SEARCH_PREFIX

class WordAdapter(val letterid:String, context: Context):
    RecyclerView.Adapter<WordAdapter.viewHolders>() {
    private val filteredWords: List<String>

    init {
        val word=context.resources.getStringArray(R.array.words).toList()
        filteredWords =word.filter { it.startsWith(letterid,ignoreCase = true) }
            .shuffled().take(5).sorted()
    }

    class viewHolders (val view: View):RecyclerView.ViewHolder(view){
    val btn:Button=view.findViewById(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolders {
        val layout=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return viewHolders(layout)
    }

    override fun onBindViewHolder(holder: viewHolders, position: Int) {

        val item = filteredWords[position]
        // Needed to call startActivity
        val context = holder.view.context

        // Set the text of the WordViewHolder
        holder.btn.text = item

        // Assigns a [OnClickListener] to the button contained in the [ViewHolder]
        holder.btn.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${word.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = filteredWords.size
}