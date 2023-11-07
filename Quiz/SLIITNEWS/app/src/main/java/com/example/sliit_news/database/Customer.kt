package com.example.sliit_news.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer(
    var userName:String?,
    var email:String?,
    var password:String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

}
