package com.beerdie.letstoss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_selection.*


class SelectionActivity :  AppCompatActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        startGameButton.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java).apply {
                putExtra(
                    "team1Name",
                    team1Input.text
                )
                putExtra(
                    "team2Name",
                    team2Input.text
                )
            })


        }
    }


}


