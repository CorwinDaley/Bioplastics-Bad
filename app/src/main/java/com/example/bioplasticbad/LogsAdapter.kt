package com.example.bioplasticbad.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bioplasticbad.R
import com.example.bioplasticbad.logs
import java.text.DateFormat.getDateInstance

class LogsAdapter(private val log: List<logs>) : RecyclerView.Adapter<LogsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //which layout is it?
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.fragment_logging_layout, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return log.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Log.d("Number of items logged", "List Count :${log.size} ")

        return holder.bind(log[position])

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //links object to layout fields
        fun bind(log: logs) {
            itemView.findViewById<TextView>(R.id.textView_Entry_itemName).text = log.plasticName
            //image
            //itemView.findViewById<>()
            itemView.findViewById<TextView>(R.id.textView_Entry_journalEntry).text = "Date:" + log.journal.dateComposted + " " + log.journal.userNotes
            //maybe add image string later...

        }

    }
}
