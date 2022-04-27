package com.example.bioplasticbad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class newOrEditJournal : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_journals, container, false)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journals, container, false)

        val cancelButton = rootView.findViewById<Button>(R.id.button_newJournal_cancel)

        cancelButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_newJounral_to_Logging)
        }

    }

}