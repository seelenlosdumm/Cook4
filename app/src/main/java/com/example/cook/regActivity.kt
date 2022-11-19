package com.example.cook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.example.cook.databinding.ActivityMainBinding
import com.example.cook.databinding.ActivityRegBinding
import java.util.regex.Pattern

class regActivity : AppCompatActivity() {

    lateinit var bindingClassReg: ActivityRegBinding
    lateinit var  handler: DataBaseHelper
    var str = "srr"


    fun isValidString(str: String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClassReg = ActivityRegBinding.inflate(layoutInflater)
        setContentView(bindingClassReg.root)
        handler = DataBaseHelper(this)
    }
    
    fun perexodAuth(view: View){
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }
    
    fun perexodMain(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    
    fun perexodOsnova(view: View) {
        val email = bindingClassReg.emailField.text.toString()
        Log.d("MyLog", "email = $email")

        if (bindingClassReg.emailField.text.toString() == "") {
            Toast.makeText(this, "Заполните поле Email", Toast.LENGTH_SHORT).show()
        } else {
            if (bindingClassReg.passwordField.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Заполните поле пароль", Toast.LENGTH_SHORT).show()
            } else {
                if (bindingClassReg.passwordField2.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "Заполните поле повторите пароль", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    if (bindingClassReg.nameField.text.toString().isNullOrEmpty()) {
                        Toast.makeText(this, "Заполните поле имя", Toast.LENGTH_SHORT).show()
                    } else {

                        if (bindingClassReg.passwordField.text.trim().toString() != bindingClassReg.passwordField2.text.trim().toString()) {
                            Log.d("pass", "pass1 = ${bindingClassReg.passwordField.text.toString()}")
                            Log.d("pass", "pass2 = ${bindingClassReg.passwordField2.text.toString()}")
                            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                        } else {

                            var email: String = bindingClassReg.emailField.text.toString()
                            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(bindingClassReg.emailField.text.toString())
                                    .matches()
                            ) {
                                Toast.makeText(this, "Некорректный email", Toast.LENGTH_SHORT)
                                    .show()
                            } else {
                                handler.insertUserData(
                                    bindingClassReg.nameField.text.toString(),
                                    bindingClassReg.emailField.text.toString(),
                                    bindingClassReg.passwordField.text.toString()
                                )
                                Toast.makeText(this,"Регистрация прошла успешно", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, OsnovaActivity::class.java)
                                startActivity(intent)
                            }
                        }
                    }
                }
            }
        }
    }
}



