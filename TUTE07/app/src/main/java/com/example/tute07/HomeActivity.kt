package com.example.tute07

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class HomeActivity : AppCompatActivity() {

    lateinit var imageView: ImageView

    val thumbnailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if(it.resultCode == RESULT_OK){
            val data = it.data
            val imageBitmap = data?.extras?.get("data") as? Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val button2:Button = findViewById(R.id.button2)
        val button3:Button = findViewById(R.id.button3)
        val button4:Button = findViewById(R.id.button4)
        val button5:Button = findViewById(R.id.button5)
        val button6:Button = findViewById(R.id.button6)
        val button7:Button = findViewById(R.id.button7)
        imageView = findViewById(R.id.imageView)

        button2.setOnClickListener {
            //Explicit intent
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        button3.setOnClickListener {
            val number = "+94775843047"
            val uri = Uri.parse(String.format("tel: $number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }

        button4.setOnClickListener {
            val number = "+94775843047"
            val smsText = "Welcome to MAD 2023"
            val uri = Uri.parse(String.format("smsto: $number"))
            val intent = Intent()
            intent.action = Intent.ACTION_SENDTO
            intent.data = uri
            intent.putExtra("sms_body", smsText)
            startActivity(intent)
        }

        button5.setOnClickListener {
            val url = "https://www.sliit.lk"
            val uri = Uri.parse(url)
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = uri
            startActivity(intent)
        }

        button6.setOnClickListener {
            val mailTo = arrayOf("abc@email.com", "xyz@email.com")
            val subject = "Test Email"
            val mailBody = "This is the test mail body"

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL,mailTo)
            intent.putExtra(Intent.EXTRA_SUBJECT,subject)
            intent.putExtra(Intent.EXTRA_TEXT,mailBody)
            startActivity(intent)
        }

        button7.setOnClickListener {
            val intent = Intent()
            intent.action = MediaStore.ACTION_IMAGE_CAPTURE
            thumbnailLauncher.launch(intent)
        }


    }
}