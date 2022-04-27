package com.example.bioplasticbad

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import java.time.LocalDate
import java.time.LocalTime
import java.time.Period
import java.time.Period.between
import java.time.format.DateTimeFormatter
import java.util.*


class LoggingLayout : Fragment() {

    var testAccount = account("JoneCat69","Password!","google.com/search?q=image_of_a_profile_picture")
    var testJournal = journal("2022.04.07","google.com/search?q=image_of_a_water_bottle","The water bottle is has begun degrading")
    var testLogs = logs("Water Bottle", "google.com/search?q=image_of_a_water_bottle","2022.04.07", testJournal)
    var testPersonal = personal("Jonas","He/Him","2022.04.01",1,0)
    var testUser = User(testAccount, testLogs, testPersonal)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(

        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_logging_layout, container, false)
        val turnCompostCount = rootView.findViewById<TextView>(R.id.textView_logging_dayCountVal)
        var turnDate = LocalDate.parse(testUser.Logs.lastComposted, DateTimeFormatter.ofPattern("yyyy.MM.dd", Locale.ENGLISH))
        var currentDate = LocalDate.now()

        var daySince = between(turnDate, currentDate).days



        turnCompostCount.text = daySince.toString() + " Days Ago"

        //val listOfLogs = rootView.findViewById<RecyclerView>(R.id.recyclerView)

        val newOrEditJournalButton = rootView.findViewById<Button>(R.id.button_logging_newEntry)
        newOrEditJournalButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.editJournal)
        }

        val updateDayCountButton = rootView.findViewById<Button>(R.id.button_logging_turnCompost)

        updateDayCountButton.setOnClickListener {



            turnCompostCount.text = "You just turned it!"
            testUser.Logs.lastComposted = LocalDate.now().toString()

            //turnCompostCount.setText("You need to turn your compost!")
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