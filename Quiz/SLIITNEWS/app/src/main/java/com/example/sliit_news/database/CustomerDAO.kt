package com.example.sliit_news.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CustomerDAO {

    @Insert
    suspend fun insert(customer: Customer)

    @Query("SELECT * FROM Customer")
    suspend fun getAllCustomers():List<Customer>


}