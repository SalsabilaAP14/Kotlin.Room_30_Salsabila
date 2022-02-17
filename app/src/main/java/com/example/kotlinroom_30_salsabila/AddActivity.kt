package com.example.kotlinroom_30_salsabila

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinroom_30_salsabila.room.Movie
import com.example.kotlinroom_30_salsabila.room.MovieDb
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    val db by lazy { MovieDb(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setupView()
        setUpListener()
    }

    fun setupView(){
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun setUpListener(){
        btn_save.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.MovieDao().addMovie(
                    Movie(id = 0, et_title.text.toString(),
                    et_description.text.toString())
                )

                finish()
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}