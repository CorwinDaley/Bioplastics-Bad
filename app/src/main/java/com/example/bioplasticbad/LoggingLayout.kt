package com.example.bioplasticbad

import android.os.Bundle
import android.os.CountDownTimer
import android.telecom.Call
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bioplasticbad.helpers.LogsAdapter



class LoggingLayout : Fragment() {

    var testAccount = account("JoneCat69","Password!","google.com/search?q=image_of_a_profile_picture")
    var testJournal = journal("2022.4.7","google.com/search?q=image_of_a_water_bottle","The water bottle is has begun degrading")
    var testLogs = logs("Water Bottle", "google.com/search?q=image_of_a_water_bottle","2022.4.7", testJournal)
    var testPersonal = personal("Jonas","He/Him","2022.4.1",1,0)
    var testUser = User(testAccount, testLogs, testPersonal)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(

        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_logging_layout, container, false)
        val turnCompostCount = rootView.findViewById<TextView>(R.id.textView_logging_dayCountVal)
        turnCompostCount.setText("You haven't yet!")
        //val listOfLogs = rootView.findViewById<RecyclerView>(R.id.recyclerView)

        val newOrEditJournalButton = rootView.findViewById<Button>(R.id.button_logging_newEntry)
        newOrEditJournalButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.editJournal)
        }

        val updateDayCountButton = rootView.findViewById<Button>(R.id.button_logging_turnCompost)

        updateDayCountButton.setOnClickListener {

            Toast.makeText(activity?.applicationContext, "turn your compost button", Toast.LENGTH_LONG).show()

            turnCompostCount.setText("7 Days Ago")
            var days = 8
            val oneDayInMilliSec: Long = 86400000
            val timer = object: CountDownTimer(oneDayInMilliSec*7, oneDayInMilliSec) {
                override fun onTick(millisUntilFinished: Long) {
                    days--
                    turnCompostCount.setText(days.toString() + " Days Ago")
                }
                override fun onFinish() {
                    turnCompostCount.setText("You need to turn your compost!")
                    Toast.makeText(activity?.applicationContext, "You need to turn your compost!", Toast.LENGTH_LONG).show()
                }
            }
            timer.start()
        }

        /*listOfLogs.adapter = LogsAdapter(emptyList<logs>())
        listOfLogs.layoutManager

        listOfLogs.apply {
            setHasFixedSize(true)
            adapter = LogsAdapter(emptyList<logs>())
        }

        listOfLogs.adapter?.notifyDataSetChanged()*/

        return rootView
    }


}