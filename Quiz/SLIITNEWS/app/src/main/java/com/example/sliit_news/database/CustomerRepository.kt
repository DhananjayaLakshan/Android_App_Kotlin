package com.example.sliit_news.database

class CustomerRepository(
    private val db:CustomerDatabase
) {
    suspend fun insert(customer: Customer) = db.getCustomerDao().insert(customer)
}