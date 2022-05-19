package com.example.bioplasticbad

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.google.android.material.bottomnavigation.BottomNavigationView


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

        val homepageFragment = R.layout.fragment_homepage
        val profileFragment = R.layout.fragment_account_layout
        val loggingFragment= R.layout.fragment_logging_layout
        val instructionsFragment = R.layout.fragment_instructions



        var bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

            bottomNav.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.navigation_home->setCurrentFragment(homepageFragment)
                    R.id.navigation_person->setCurrentFragment(profileFragment)
                    R.id.navigation_add_circle->setCurrentFragment(loggingFragment)
                    R.id.navigation_library_books->setCurrentFragment(instructionsFragment)
                    R.id.navigation_store->Toast.LENGTH_LONG
            }
                true
        }



    }

    private fun setCurrentFragment(newFragment: Fragment ) =
        supportFragmentManager.beginTransaction().apply {
        replace(R.layout.activity_main as Int, newFragment)
            commit()
        }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }



}