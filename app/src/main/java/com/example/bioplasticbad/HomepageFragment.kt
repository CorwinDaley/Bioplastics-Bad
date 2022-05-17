package com.example.bioplasticbad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class HomepageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userId = savedInstanceState?.getString(MainActivity.USER_ID_KEY)
    }

    override fun onCreateView(

        inflater:LayoutInflater, container : ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_homepage, container, false)

        val logoutButton = rootView.findViewById<Button>(R.id.button_homePage_logOut)
        logoutButton.setOnClickListener {
            Backendless.UserService.logout(object : AsyncCallback<Void?>{
                override fun handleResponse(response: Void?) {
                    view?.findNavController()?.navigate(R.id.action_homepage_to_loginFragment, savedInstanceState)
                }

                override fun handleFault(fault: BackendlessFault?) {

                }

            })
        }



        val profilePageFragmentButton = rootView.findViewById<Button>(R.id.button_profilePageFragment_homePage)
        profilePageFragmentButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homepageFragment_to_profilePageFragment, savedInstanceState)
        }

        val instructionsFragmentButton = rootView.findViewById<Button>(R.id.button_instructionsFragment_homePage)
        instructionsFragmentButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homepageFragment_to_instructionsFragment, savedInstanceState)
        }

        val toLoggingButton = rootView.findViewById<Button>(R.id.button_loggingFragment_homePage)
        toLoggingButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homepageFragment_to_loggingFragment, savedInstanceState)
        }


        // accessing the bundle that got you here uses arguments
        arguments?.getString(LoginFragment.LOGIN_KEY)


        return rootView
    }
}