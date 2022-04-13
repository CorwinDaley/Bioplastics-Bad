package com.example.bioplasticbad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this,navController)

        var testAccount = account("JoneCat69","Password!","google.com/search?q=image_of_a_profile_picture")
        var testJournal = journal("2022.4.7","google.com/search?q=image_of_a_water_bottle","The water bottle has begun degrading")
        var testLogs = logs("Water Bottle", "google.com/search?q=image_of_a_water_bottle","2022.4.7", testJournal)
        var testPersonal = personal("Jonas","He/Him","2022.4.1",1,0)
        var testUser = User(testAccount, testLogs, testPersonal)

        val loggingButton = findViewById<Button>(R.id.button_main_log)
        loggingButton.setOnClickListener {
            Toast.makeText(this, "Log button has been pressed", Toast.LENGTH_LONG).show()
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

}