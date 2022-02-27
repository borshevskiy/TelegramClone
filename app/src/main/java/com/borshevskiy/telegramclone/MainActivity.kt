package com.borshevskiy.telegramclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.borshevskiy.telegramclone.databinding.ActivityMainBinding
import com.borshevskiy.telegramclone.utils.AUTH
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AUTH = FirebaseAuth.getInstance()
        navController = findNavController(R.id.nav_host_fragment_content_main)
        if (AUTH.currentUser == null) {
            navController.navigate(R.id.nav_enterPhoneNumber)
        }
        setSupportActionBar(binding.toolbar)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_chat, R.id.nav_create_group, R.id.nav_create_secret_chat,
                R.id.nav_create_channel, R.id.nav_contacts, R.id.nav_calls,
                R.id.nav_favorites, R.id.nav_settings, R.id.nav_invite_friends,
                R.id.nav_about), binding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}