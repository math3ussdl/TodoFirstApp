package com.adsap.todofirst.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.adsap.todofirst.R

class ListDataActivity : AppCompatActivity() {

    lateinit var title : TextView
    lateinit var description : TextView
    lateinit var author : TextView
    lateinit var category : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data)

        title = findViewById(R.id.tv_title)
        description = findViewById(R.id.tv_description)
        author = findViewById(R.id.tv_author)
        category = findViewById(R.id.tv_category)

        title.text = intent.getStringExtra("title")
        description.text = intent.getStringExtra("description")
        author.text = intent.getStringExtra("author")
        category.text = intent.getStringExtra("category")
    }
}