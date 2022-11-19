package com.example.cook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.cook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClassVhod : ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClassVhod = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClassVhod.root)
    }

    fun perexod(view: View ){
        val intent = Intent(this, regActivity::class.java)
        startActivity(intent)
    }

    fun perexod2(view: View ){
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

    }
}