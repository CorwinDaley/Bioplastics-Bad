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

class HomepageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(

        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_homepage, container, false)

        val profilePageFragmentButton = rootView.findViewById<Button>(R.id.button_profilePageFragment_homePage)
        profilePageFragmentButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homepageFragment_to_profilePageFragment)
        }

        val instructionsFragmentButton = rootView.findViewById<Button>(R.id.button_instructionsFragment_homePage)
        instructionsFragmentButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homepageFragment_to_instructionsFragment)
        }

        val toLoggingButton = rootView.findViewById<Button>(R.id.button_loggingFragment_homePage)
        toLoggingButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homepageFragment_to_loggingFragment)
        }


        return rootView
    }
}