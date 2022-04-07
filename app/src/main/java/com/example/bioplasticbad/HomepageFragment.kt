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
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomepageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomepageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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

        val loggingfragmentButton = rootView.findViewById<Button>(R.id.button_loggingFragment_homePage)
        loggingfragmentButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homepageFragment_to_loggingFragment)
        }

        val instructionsFragmentButton = rootView.findViewById<Button>(R.id.button_instructionsFragment_homePage)
        instructionsFragmentButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homepageFragment_to_instructionsFragment)
        }

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment homepage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomepageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}