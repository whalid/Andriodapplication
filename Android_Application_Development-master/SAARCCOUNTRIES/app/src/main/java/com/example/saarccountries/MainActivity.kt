package com.example.saarccountries

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout:DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    private lateinit var countryname:String
    private lateinit var buttonView:ScrollView
    lateinit var adapter:ArrayAdapter<String>

    private lateinit var bdButton: Button
    private lateinit var inButton: Button
    private lateinit var pakButton: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            drawerLayout = findViewById(R.id.drawerId)
            toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            val navigationView = findViewById<NavigationView>(R.id.navigationId)
            navigationView.setNavigationItemSelectedListener(this)



            bdButton = findViewById (R.id.bdButtonId)
            inButton = findViewById (R.id.inButtonId)
            pakButton = findViewById (R.id.pakButtonId)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        lateinit var intent:Intent

        if(item.itemId == R.id.homeId){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        else if(item.itemId == R.id.profileId){
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        else if(item.itemId == R.id.chatId){
            intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
        return false
    }

    fun myFun(view: View){
        if(view.id == R.id.bdButtonId){
            bdButton.setOnClickListener{
                intent = Intent(this, CountryProfileActivity::class.java)
                intent.putExtra("name", "bangladesh")
                startActivity(intent)
            }
        }
        else if(view.id == R.id.inButtonId){
            inButton.setOnClickListener{
                intent = Intent(this, CountryProfileActivity::class.java)
                intent.putExtra("name", "india")
                startActivity(intent)
            }
        }
        else if(view.id == R.id.pakButtonId){
            pakButton.setOnClickListener{
                intent = Intent(this, CountryProfileActivity::class.java)
                intent.putExtra("name", "pakistan")
                startActivity(intent)
            }
        }
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater:MenuInflater = menuInflater
        menuInflater.inflate(R.menu.search_menu, menu)

        val menuitem: MenuItem? = menu?.findItem(R.id.searchId)
        val searchView:SearchView = menuitem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }


}