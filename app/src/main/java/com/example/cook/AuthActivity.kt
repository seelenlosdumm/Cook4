package com.example.cook

import android.content.AsyncQueryHandler
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cook.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    lateinit var bindingClassAuth: ActivityAuthBinding
    lateinit var handler: DataBaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClassAuth = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(bindingClassAuth.root)
        handler = DataBaseHelper(this)

    }
    fun perexodMain(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun perexodReg(view: View){
        val intent = Intent(this, regActivity::class.java)
        startActivity(intent)
    }

    fun perexodOsnova(view: View){

        if(handler.UserPresent(bindingClassAuth.emailField3.text.toString(),bindingClassAuth.passwordField3.text.toString())) {
            Toast.makeText(this,"Авторизация прошла успешно", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, OsnovaActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,":Email или пароль неверны", Toast.LENGTH_SHORT).show()
        }
    }
}