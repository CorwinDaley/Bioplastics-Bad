package com.example.bioplasticbad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault


class MainActivity : AppCompatActivity() {

    companion object{
        val USER_ID_KEY = "USERIDKEY"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connect the backendless to our account
        Backendless.initApp(this,
            "B6BC75E8-E224-40E6-FFF3-0493FAE41F00",
            "2492C2DA-9DD5-436A-A97E-27B6DCAB1FFF" )

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this,navController)





        val loggingButton = findViewById<Button>(R.id.button_main_log)
        loggingButton.setOnClickListener {
            Toast.makeText(this, "Log button has been pressed", Toast.LENGTH_LONG).show()
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }



    fun getAccount(username: String, password: String) {

    // Connect the backendless to our account
        Backendless.initApp( "B6BC75E8-E224-40E6-FFF3-0493FAE41F00", "neededlettuce.backendless.app" )

        // Double check for null usernames or passwords first please!

        Backendless.UserService.login(
            username,
            password,

            object : AsyncCallback<BackendlessUser?> {

                override fun handleResponse(user: BackendlessUser?){
                    // User has logged in
                    var ownerId = user?.objectId
                    var bundle = Bundle()
                    bundle.putString(USER_ID_KEY,ownerId)

                }

                override fun handleFault(fault: BackendlessFault){
                    // Error has occurred
                }
            }
        )

        //var account = Backendless.Data.of( Account::class.java ).findById(ownerId, object : AsyncCallback<Account> {
        //    override fun handleResponse(response: Account?) {
        //        TODO("Not yet implemented")
        //    }
        //
        //    override fun handleFault(fault: BackendlessFault?) {
        //        TODO("Not yet implemented")
        //    }
        //})
    }



}