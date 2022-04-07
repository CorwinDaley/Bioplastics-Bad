package com.example.bioplasticbad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var testAccount = account("JoneCat69","Password!","google.com/search?q=image_of_a_profile_picture")
        var testJournal = journal("2022.4.7","google.com/search?q=image_of_a_water_bottle","The water bottle is has begun degrading")
        var testLogs = logs("Water Bottle", "google.com/search?q=image_of_a_water_bottle","2022.4.7", testJournal)
        var testPersonal = personal("Jonas","He/Him","2022.4.1",1,0)
        var testUser = User(testAccount, testLogs, testPersonal)
    }
}