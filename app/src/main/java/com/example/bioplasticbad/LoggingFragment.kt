package com.example.bioplasticbad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import java.util.*


class LoggingFragment : Fragment() {

    lateinit var turnCompostCount : TextView
    lateinit var newOrEditJournal : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
            testUser?.setProperty("lastComposted", currentDate)
        }
    }

    override fun onCreateView(

        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
    // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_logging_layout, container, false)
        turnCompostCount = rootView.findViewById<TextView>(R.id.textView_logging_dayCountVal)


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

        val newOrEditJournalButton = rootView.findViewById<Button>(R.id.button_logging_newEntry)
        newOrEditJournalButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.NewOrEditJournal)
        }

        val updateDayCountButton = rootView.findViewById<Button>(R.id.button_logging_turnCompost)

        updateDayCountButton.setOnClickListener {
            turnCompostCount.text = "You just turned it!"
        }

        return rootView
    }

}