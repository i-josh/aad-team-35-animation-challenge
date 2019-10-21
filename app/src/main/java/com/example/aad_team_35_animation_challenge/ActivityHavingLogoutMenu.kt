package com.example.aad_team_35_animation_challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import com.example.aad_team_35_animation_challenge.auth.AuthActivity
import com.example.aad_team_35_animation_challenge.auth.listeners.OnLogoutListener

/** This activity only holds a menu with logout functionality
 * is should be replaced with the appropriate start/main activity
 * or if logout function is to be performed from button click
 * the necessary code should be copied and transferred to
 * button click listener
 * */

class ActivityHavingLogoutMenu : AppCompatActivity(), OnLogoutListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_having_logout_menu)
    }

    override fun logout() {
        //changed to boolean pref
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = preferences.edit()

        editor.putBoolean(getString(R.string.user_logged_in),false)
        editor.apply()
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.logout_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> logout()
        }
        return super.onOptionsItemSelected(item)
    }
}
