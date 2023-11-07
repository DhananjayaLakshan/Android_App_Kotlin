package com.example.sliit_news.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Customer::class], version = 1)
abstract class CustomerDatabase:RoomDatabase() {
    abstract fun getCustomerDao():CustomerDAO

    companion object{

        @Volatile
        private var INSTANCE:CustomerDatabase? = null

        fun getInstance(context: Context):CustomerDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context,
                    CustomerDatabase::class.java,
                    "customer_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }


    }
}

