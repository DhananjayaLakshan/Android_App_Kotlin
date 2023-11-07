package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtUserName:EditText = findViewById(R.id.edtUserName)
        val edtPassword:EditText = findViewById(R.id.edtPassword)

        val btnLogin:Button = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener(){

            val formData = FormData(
                edtUserName.text.toString(),
                edtPassword.text.toString()
            )

            val  userNameValidation = formData.validUserName()
            val passwordValidation = formData.validPasword()

            when(userNameValidation){
                is ValidationResult.Empty -> { edtUserName.error = userNameValidation.errorMessage }
                is ValidationResult.Invalid -> {edtUserName.error = userNameValidation.errorMessage}
                ValidationResult.Valid -> { count++ }
            }

            when(passwordValidation){
                is ValidationResult.Empty -> { edtPassword.error = passwordValidation.errorMessage }
                is ValidationResult.Invalid -> {
                    edtPassword.error = passwordValidation.errorMessage
                    Toast.makeText(this,"Invalid Password", Toast.LENGTH_LONG).show()
                }
                ValidationResult.Valid -> { count++ }
            }

            if (count == 2){
                Toast.makeText(this,"Loggedin", Toast.LENGTH_LONG).show()
            }

        }


    }
}