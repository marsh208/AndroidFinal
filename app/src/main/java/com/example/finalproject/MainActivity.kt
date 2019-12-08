package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newGameButton.setOnClickListener()
        {
            startActivity(Intent(this, SelectionActivity::class.java))
        }

        rulesButton.setOnClickListener{
            startActivity(Intent(this, RulesActivity::class.java))
        }


    }
}
