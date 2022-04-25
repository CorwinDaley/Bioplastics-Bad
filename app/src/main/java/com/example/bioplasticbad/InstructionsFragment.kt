package com.example.bioplasticbad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentContainer
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InstructionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionsFragment : Fragment() {
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
        val rootView = inflater.inflate(R.layout.fragment_instructions, container, false)

        val compostingInstructionsButton = rootView.findViewById<Button>(R.id.button_basicCompostingInstruction_instructionFragment)
        compostingInstructionsButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_instructionsFragment_to_basicCompostingInstructionFragment)
        }

        val insulateHeatInstructionButton = rootView.findViewById<Button>(R.id.button_insulateHeatInstruction_instructionFragment)
        insulateHeatInstructionButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_instructionsFragment_to_insulateHeatInstructionFragment)
        }

        val readBioplasticLabelsButton = rootView.findViewById<Button>(R.id.button_readBioplasticLabels_instructionFragment)
        readBioplasticLabelsButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_instructionsFragment_to_readBioplasticLabelsFragment)
        }



        return rootView
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InstructionsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}