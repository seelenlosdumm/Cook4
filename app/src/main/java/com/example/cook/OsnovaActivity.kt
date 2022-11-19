package com.example.cook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class OsnovaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_osnova)
    }
    fun perexodMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}