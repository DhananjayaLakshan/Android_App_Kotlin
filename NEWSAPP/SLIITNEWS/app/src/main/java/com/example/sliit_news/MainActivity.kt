package com.example.sliit_news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sliit_news.database.News
import com.example.sliit_news.database.NewsDatabase
import com.example.sliit_news.database.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NewsAdapter
    private lateinit var viewModel: MainActivityData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCategory: Button = findViewById(R.id.btnCatogery)

        btnCategory.setOnClickListener(){
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
//            finish()
        }



        val recyclerView: RecyclerView = findViewById(R.id.rvNewsList)
        val repository = NewsRepository(NewsDatabase.getInstance(this))

        viewModel = ViewModelProvider(this)[MainActivityData::class.java]

        viewModel.data.observe(this) {
            adapter = NewsAdapter(it, repository, viewModel)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getAllNewsItems()

            runOnUiThread {
                viewModel.setData(data)
            }
        }

        val addItem: ImageView = findViewById(R.id.btnAddItem)

        addItem.setOnClickListener {
            displayAlert(repository)
        }
    }


    private fun displayAlert(repository: NewsRepository) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getText(R.string.alertTitle))
        builder.setMessage("Enter News Below:")

        val formLayout = layoutInflater.inflate(R.layout.form_layout, null)
        val etItem = formLayout.findViewById<EditText>(R.id.etItem)
        val etDescription = formLayout.findViewById<EditText>(R.id.etDescription)
        val etDate = formLayout.findViewById<EditText>(R.id.etDate)

        builder.setView(formLayout)

        builder.setPositiveButton("ADD") { dialog, which ->
            val item        = etItem.text.toString()
            val description = etDescription.text.toString()
            val date        = etDate.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                repository.insert(News(item, description, date))
                val data = repository.getAllNewsItems()
                runOnUiThread {
                    viewModel.setData(data)
                }
            }
        }

        builder.setNegativeButton("BACK") { dialog, which ->
            dialog.cancel()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }

}
