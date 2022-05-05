package com.example.bioplasticbad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class NewOrEditJournal : Fragment() {

    var testAccount = account("JoneCat69","Password!","google.com/search?q=image_of_a_profile_picture")
    var testJournal = journal("2022.04.07","google.com/search?q=image_of_a_water_bottle","The water bottle is has begun degrading")
    var testLogs = logs("Water Bottle", "google.com/search?q=image_of_a_water_bottle","2022.04.17", testJournal)
    var testPersonal = personal("Jonas","He/Him","2022.04.01",1,0)
    var testUser = User(testAccount, testLogs, testPersonal)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_journals, container, false)
        // Inflate the layout for this fragment
        val cancelButton = rootView.findViewById<Button>(R.id.button_newJournal_cancel)
        val finishButton = rootView.findViewById<Button>(R.id.button_newJournal_finish)
        val entry = rootView.findViewById<EditText>(R.id.textView_newJournal_itemName)
        val itemName = rootView.findViewById<EditText>(R.id.textView_newJournal_itemName)
        val blankText = ""

        cancelButton.setOnClickListener {
            //just need to reset and go back
            entry.setText(blankText)
            itemName.setText(blankText)
            view?.findNavController()?.navigate(R.id.action_newJournal_to_Logging)

        }
        finishButton.setOnClickListener {
            // add all the values in the edit texts to the user's journal object before going back
            // add to journal string b/c no array yet :///



            entry.setText(blankText)
            itemName.setText(blankText)
            view?.findNavController()?.navigate(R.id.action_newJournal_to_Logging)
        }
        return rootView
    }

}