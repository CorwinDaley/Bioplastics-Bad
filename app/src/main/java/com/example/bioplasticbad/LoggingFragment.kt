package com.example.bioplasticbad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.findNavController


class LoggingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(

        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_logging_layout, container, false)

        val newEntry = rootView.findViewById<Button>(R.id.button_logging_newEntry)


       val newOrEditJournalButton = rootView.findViewById<Button>(R.id.button_logging_newEntry)
        newOrEditJournalButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.NewOrEditJournal)
        }

        val updateDayCountButton = rootView.findViewById<Button>(R.id.button_logging_newEntry)
        updateDayCountButton.setOnClickListener {
        }



        return rootView
    }

}