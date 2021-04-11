package com.example.latfragmentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navControl = this.findNavController(R.id.nav_host_fragment_container)
        NavigationUI.setupActionBarWithNavController(this,navControl)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navControl = this.findNavController(R.id.nav_host_fragment_container)
        return navControl.navigateUp()
    }
}