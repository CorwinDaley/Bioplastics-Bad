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
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*


class LoggingLayout : Fragment() {

    var testAccount = account("JoneCat69","Password!","google.com/search?q=image_of_a_profile_picture")
    var testJournal = journal("2022.4.7","google.com/search?q=image_of_a_water_bottle","The water bottle is has begun degrading")
    var testLogs = logs("Water Bottle", "google.com/search?q=image_of_a_water_bottle","2022.4.7", testJournal)
    var testPersonal = personal("Jonas","He/Him","2022.4.1",1,0)
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
        turnCompostCount.setText("You haven't yet!")
        //val listOfLogs = rootView.findViewById<RecyclerView>(R.id.recyclerView)

        val newOrEditJournalButton = rootView.findViewById<Button>(R.id.button_logging_newEntry)
        newOrEditJournalButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.editJournal)
        }

        val updateDayCountButton = rootView.findViewById<Button>(R.id.button_logging_turnCompost)

        updateDayCountButton.setOnClickListener {

            turnCompostCount.setText(" Days Ago")
            var turnDate = LocalDate.parse(testUser.Logs.lastComposted)
            var currentDate = LocalDate.now()
            var daySince = calculatePeriod(turnDate, currentDate)



            turnCompostCount.setText(daySince.toString() + " Days Ago")



            //turnCompostCount.setText("You need to turn your compost!")
            Toast.makeText(activity?.applicationContext, "You need to turn your compost!", Toast.LENGTH_LONG).show()
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculatePeriod(
        startDate: LocalDate?,
        endDate: LocalDate?
    ): Period? {
        val period = Period.between(startDate, endDate)
        return period
    }


}