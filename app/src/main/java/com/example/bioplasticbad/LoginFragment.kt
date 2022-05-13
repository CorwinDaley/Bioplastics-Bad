package com.example.bioplasticbad

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault

class LoginFragment : Fragment() {
    companion object {
        val LOGIN_KEY = "j7o%g71Ps"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Async callback, obtains current user object

//        if (Backendless.UserService.loggedInUser() != null) {
//            Backendless.UserService.CurrentUser(true, object : AsyncCallback<BackendlessUser> {
//                override fun handleResponse(user: BackendlessUser?) {
//                    // User has logged in
//                    var ownerId = user?.objectId
//                    var bundle = Bundle()
//                    bundle.putString(MainActivity.USER_ID_KEY, ownerId)
//
//                    findNavController().navigate(R.id.action_loginFragment_to_homepage, bundle)
//                }
//
//                override fun handleFault(fault: BackendlessFault?) {
//
//                }
//            })
//        }

        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_account_login, container, false)

        // wire any widgets and do click listeners between here
        val usernameInput = rootView.findViewById<EditText>(R.id.editText_accountLogin_username)
        val passwordInput = rootView.findViewById<EditText>(R.id.editText_accountLogin_password)
        val nextButton = rootView.findViewById<Button>(R.id.button_accountLogin_next)
        val newAccountButton = rootView.findViewById<Button>(R.id.button_accountLogin_createAccount)

        val rememberMeBox = rootView.findViewById<CheckBox>(R.id.checkBox_accountLogin_rememberMe)

        newAccountButton.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

        nextButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            loginAccount(username, password, rememberMeBox.isChecked)
        }

        return rootView
    }


    fun loginAccount(username: String, password: String, stayLoggedIn: Boolean) {


        // Double check for null usernames or passwords first please!


        Backendless.UserService.login(
            username.lowercase(),
            password,

            object : AsyncCallback<BackendlessUser?> {

                override fun handleResponse(user: BackendlessUser?) {
                    // User has logged in
                    var ownerId = user?.objectId
                    var bundle = Bundle()
                    bundle.putString(MainActivity.USER_ID_KEY, ownerId)

                    findNavController().navigate(R.id.action_loginFragment_to_homepage, bundle)
                }

                override fun handleFault(fault: BackendlessFault) {
                    // Error has occurred
                    Log.d("LoginFragment", "handleFault: ${fault.message}")
                }
            },
            stayLoggedIn

        )
    }
}