package com.example.bioplasticbad

import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault


class SignupFragment : Fragment(){
    companion object {
        val SIGNUP_USERNAME_KEY = "bj5!kyF3#s"
        val SIGNUP_PASSWORD_KEY = "Puig@6n0<n"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView = inflater.inflate(R.layout.fragment_account_setup, container, false)

        // Variable declaration, separated by types of views.

        val usernameInput = rootView.findViewById<EditText>(R.id.editText_accountSetup_username)
        val passwordInput = rootView.findViewById<EditText>(R.id.editText_accountSetup_password)
        val emailInput = rootView.findViewById<EditText>(R.id.editText_accountSetup_email)
        val phoneInput = rootView.findViewById<EditText>(R.id.editText_accountSetup_phoneNumber)
        val otherInput = rootView.findViewById<EditText>(R.id.editText_accountSetup_otherGender)

        val genderInput = rootView.findViewById<RadioGroup>(R.id.radioGroup_accountSetup_gender)

        val maleButton = rootView.findViewById<RadioButton>(R.id.radioButton_accountSetup_male)
        val femaleButton = rootView.findViewById<RadioButton>(R.id.radioButton_accountSetup_female)
        val otherButton = rootView.findViewById<RadioButton>(R.id.radioButton_accountSetup_other)

        val nextButton = rootView.findViewById<Button>(R.id.button_accountSetup_next)

        fun nullChecker(): Boolean{
            if(usernameInput.text.toString() == "" || passwordInput.text.toString() == "" || emailInput.text.toString() == ""){
                return false
            }
            return true
        }


        nextButton.setOnClickListener(){
            val username = usernameInput.text.toString()
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            val user = BackendlessUser()

            user.setProperty("username", username.lowercase())
            user.password = password
            user.email = email
            Log.d("nextbutton", "onCreateView: we clicked the button")

            if (nullChecker()) {

            Backendless.UserService.register(user, object : AsyncCallback<BackendlessUser?> {
                override fun handleResponse(registeredUser: BackendlessUser?) {
                    // user has been registered and now can login

                    var bundle = Bundle()
                    bundle.putString(SIGNUP_USERNAME_KEY, username)
                    bundle.putString(SIGNUP_PASSWORD_KEY, password)

                    findNavController().navigate(R.id.action_signupFragment_to_loginFragment, bundle)
                    Log.d("success", "handleResponse: ${registeredUser?.userId}")
                }

                override fun handleFault(fault: BackendlessFault) {


                    // an error has occurred, the error code can be retrieved with fault.getCode()
                    val errorCode = fault.code
                    var errorMessage = "$errorCode: " + when (errorCode) {
                      "3009" -> "User registration is closed at this time, please come back later."
                      "3010" -> "Please do not use special characters in your username or password"
                      "3011" -> "Missing password"
                      "3012" -> "Fill out all required fields"
                      "3013" -> "Missing an identity"
                      "3014" -> "An external error has occured, please try again"
                      "3021" -> "General error"
                      "3033" -> "That username already exists"
                      "3038" -> "Missing session ID"
                      "3039" -> "Invalid session ID"
                      "3040" -> "Incorrect email address"
                      "3041" -> "Fill out all required fields"
                      "3043" -> "Matching user exists"
                      "8000" -> "Exceeded character limit"

                        else -> {
                            "An unknown error has occurred"
                        }

                    }
                    Log.d("Signup Fragment", "handleFault: $errorMessage \n${fault.message}\n${fault.detail}")


                }
            })
            } else {
                Toast.makeText(requireActivity(), "Please fill out your password and username", Toast.LENGTH_LONG).show()
                nextButton.background.alpha = 100

            }


        }


        return rootView
    }

}