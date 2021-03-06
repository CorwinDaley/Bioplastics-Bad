package com.example.bioplasticbad

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.navigation.findNavController
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.backendless.persistence.DataQueryBuilder
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class NewOrEditJournal : Fragment(){

    lateinit var finish : Button
    lateinit var entry : EditText
    lateinit var itemName : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Backendless.UserService.CurrentUser(true, object: AsyncCallback<BackendlessUser> {
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
        val currentDate = java.util.Calendar.getInstance()
        finish.setOnClickListener {
            // add all the values in the edit texts to the user's journal object before going back
            // add to journal string b/c no array yet :///
            //get corresponding logs based on itemName


            if(testUser?.getProperty("logs") == null) {
                //make new log for user based on plastic name
                //testUser?.setProperty("logs",)

                val plasticType = itemName.toString()
                val newJournal = journal(plasticType, entry.toString(), testUser?.getProperty("ownerId") as String, currentDate as Date, currentDate as Date)
                val newJournals : List<journal> = listOf(newJournal)
                val newLog = logs(plasticType, newJournals, testUser?.getProperty("ownerId") as String, currentDate as Date, currentDate as Date)

                testUser?.setProperty("logs", newLog)

            }
            else{
                // make new journal for user and add to exisitng log based on itemName

                val queryBuilder = DataQueryBuilder.create()
                queryBuilder.addProperties("itemName", "journal")
                Backendless.Data.of("testUser").find(queryBuilder)

              //  Log.d("NewOrEditLogFragment", "Log type: " + editedLog)


            }



            view?.findNavController()?.navigate(R.id.action_newJournal_to_Logging)
        }

    }

    override fun onCreateView(
        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_journals, container, false)
        // Inflate the layout for this fragment
        val cancelButton = rootView.findViewById<Button>(R.id.button_newJournal_cancel)
        finish = rootView.findViewById<Button>(R.id.button_newJournal_finish)
        entry = rootView.findViewById<EditText>(R.id.textView_newJournal_itemName)
        itemName = rootView.findViewById<EditText>(R.id.textView_newJournal_itemName)
        val blankText = ""

        cancelButton.setOnClickListener {
            //just need to reset and go back
            entry.setText(blankText)
            itemName.setText(blankText)
            view?.findNavController()?.navigate(R.id.action_newJournal_to_Logging)

        }
        return rootView
    }

}