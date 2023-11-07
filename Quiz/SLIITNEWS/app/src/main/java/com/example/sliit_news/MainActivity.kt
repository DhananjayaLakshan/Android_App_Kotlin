package com.example.sliit_news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sliit_news.database.Customer
import com.example.sliit_news.database.CustomerDatabase
import com.example.sliit_news.database.CustomerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = CustomerRepository(CustomerDatabase.getInstance(this))
        val viewModel = ViewModelProvider(this)[mainActivityData::class.java]

        val btnRegister:Button = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener(){

            val etUserName:EditText = findViewById(R.id.teUserName)
            val etEmail:EditText =    findViewById(R.id.teEmail)
            val edPassword:EditText = findViewById(R.id.tePassword)
            val edRepass : EditText = findViewById(R.id.teRePass)

            val userName    = etUserName.text.toString()
            val email       = etEmail.text.toString()
            val password    = edPassword.text.toString()
            val rePass = edRepass.text.toString()

            if (password != rePass){
                Toast.makeText(this,"Password does not match", Toast.LENGTH_LONG).show()
            }else{
                val cus = Customer(userName,email,password)

                CoroutineScope(Dispatchers.IO).launch {
                    repository.insert(cus)
                }
            }
        }
    }
}
