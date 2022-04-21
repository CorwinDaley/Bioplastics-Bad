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


class LoggingLayout : Fragment() {

    //var testAccount = account("JoneCat69","Password!","google.com/search?q=image_of_a_profile_picture")
   // var testJournal = journal("2022.4.7","google.com/search?q=image_of_a_water_bottle","The water bottle is has begun degrading")
   // var testLogs = logs("Water Bottle", "google.com/search?q=image_of_a_water_bottle","2022.4.7", testJournal)
   // var testPersonal = personal("Jonas","He/Him","2022.4.1",1,0)
   // var testUser = User(testAccount, testLogs, testPersonal)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(

        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_logging_layout, container, false)

        val newOrEditJournalButton = rootView.findViewById<Button>(R.id.button_logging_newEntry)
        newOrEditJournalButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.newOrEditJounral)
        }

        val updateDayCountButton = rootView.findViewById<Button>(R.id.button_logging_newEntry)
        updateDayCountButton.setOnClickListener {
        }



        return rootView
    }

}