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
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.Period
import java.time.Period.between
import java.time.format.DateTimeFormatter
import java.util.*


class LoggingLayout : Fragment() {

    lateinit var turnCompostCount : TextView
    lateinit var newOrEditJournal : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Async callback, obtains current user object
        Backendless.UserService.CurrentUser(true, object:AsyncCallback<BackendlessUser> {
            override fun handleResponse(user: BackendlessUser?) {
                // ALL DATA THAT REVOLVES AROUND THE USER MUST BE IN DISPLAYDATA
                displayData(user)
            }

            override fun handleFault(fault: BackendlessFault?) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun displayData(testUser: BackendlessUser?) {

        if(testUser?.getProperty("lastComposted") == null) {
            turnCompostCount.text = "You have't composted yet! Press the button when you turn your composted"
        } else {


            val turnDate = (testUser?.getProperty("lastComposted") as Date)

            val currentDate = java.util.Calendar.getInstance()

            var daySince: Long = (turnDate.time - currentDate.time.time) / 1000 / 60 / 60 / 24

            turnCompostCount.text = daySince.toString() + " Days Ago"

            if (daySince < 5) {
                //turnCompostCount.textColor(Color.DarkGray)
                //turnCompostCount.setTextColor(Color.parseColor("#FF0000"))
            } else if (daySince < 7) {
                //choose attention grabbing color based on aesthetics of whatever the interface ends up looking like
                //turnCompostCount.setTextColor("#0aad3f")
            } else if (daySince > 7) {
                turnCompostCount.text = "You need to turn your compost!"
            }
        }


    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(

        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_logging_layout, container, false)
        turnCompostCount = rootView.findViewById<TextView>(R.id.textView_logging_dayCountVal)
//        var turnDate = LocalDate.parse(testUser.Logs.lastComposted, DateTimeFormatter.ofPattern("yyyy.MM.dd", Locale.ENGLISH))
//        var currentDate = LocalDate.now()
//
//        var daySince = between(turnDate, currentDate).days
//
//        if (daySince < 5) {
//            //turnCompostCount.textColor(Color.DarkGray)
//            //turnCompostCount.setTextColor(Color.parseColor("#FF0000"))
//        }
//        else if (daySince < 7) {
//            //choose attention grabbing color based on aesthetics of whatever the interface ends up looking like
//            //turnCompostCount.setTextColor("#0aad3f")
//        }
//        else if (daySince > 7) {
//            turnCompostCount.text = "You need to turn your compost!"
//        }



//        turnCompostCount.text = daySince.toString() + " Days Ago"

        //val listOfLogs = rootView.findViewById<RecyclerView>(R.id.recyclerView)

        val newOrEditJournalButton = rootView.findViewById<Button>(R.id.button_logging_newEntry)
        newOrEditJournalButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.NewJournal)
        }

        val updateDayCountButton = rootView.findViewById<Button>(R.id.button_logging_turnCompost)

        updateDayCountButton.setOnClickListener {
            turnCompostCount.text = "You just turned it!"
            //testUser.Logs.lastComposted = LocalDate.now().toString()
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