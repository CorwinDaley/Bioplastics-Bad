package com.example.bioplasticbad

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [profilepage.newInstance] factory method to
 * create an instance of this fragment.
 */
class profilepage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var editable = 0
        Log.d("profilepage: ", "Editable set to " + editable)
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_account_layout, container, false)

        if (editable == 0){
            rootView.findViewById<EditText>(R.id.editText_accountLayout_name).isEnabled = false
            Log.d("profilepage: ", "Editable set to " + rootView.findViewById<EditText>(R.id.editText_accountLayout_name).isEnabled)
        }
        else if(editable == 1)
        {
            rootView.findViewById<EditText>(R.id.editText_accountLayout_name).isEnabled = true
        }

        val editProfile = rootView.findViewById<Button>(R.id.button_accountLayout_editProfile)
        editProfile.setOnClickListener {
            editable = 1
        }

        //val cancelEdit = rootView.findViewById<Button>(R.id.button_accountLayout_cancel)
        //cancelEdit.setOnClickListener{
        //    editable = 0
              //revert any changes made
        //}

        //val saveEdit = rootView.findViewById<Button>(R.id.button_accountLayout_done)
        //cancelEdit.setOnClickListener{
        //    editable = 0
              //save changes made
        //}

        return inflater.inflate(R.layout.fragment_account_layout, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment profilepage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            profilepage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}