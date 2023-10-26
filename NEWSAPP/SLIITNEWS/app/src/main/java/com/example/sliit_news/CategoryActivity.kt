package com.example.sliit_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CategoryActivity : AppCompatActivity() {

    private val businessFragment    = BusinessFragment()
    private val sportFragment       = SportFragment()
    private val politicsFragment    = PoliticsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val btnBusiness:Button  = findViewById(R.id.btnBusiness2)
        val btnSport:Button     = findViewById(R.id.btnSport2)
        val btnPolitics:Button  = findViewById(R.id.btnPolitics2)

        btnBusiness.setOnClickListener(){ loadBusiness() }

        btnSport.setOnClickListener(){ loadSport() }

        btnPolitics.setOnClickListener(){ loadPolitics() }
    }

    private fun loadBusiness(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, businessFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,businessFragment).commit()
        }

    }

    private fun loadSport(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, sportFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,sportFragment).commit()
        }

    }

    private fun loadPolitics(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, politicsFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,politicsFragment).commit()
        }

    }


}