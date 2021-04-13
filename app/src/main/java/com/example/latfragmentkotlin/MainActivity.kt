package com.example.latfragmentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.latfragmentkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navControl = this.findNavController(R.id.nav_host_fragment_container)
        NavigationUI.setupActionBarWithNavController(this,navControl)
        
        NavigationUI.setupWithNavController(binding.bottomNav, navControl)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navControl = this.findNavController(R.id.nav_host_fragment_container)
        return navControl.navigateUp()
    }
}