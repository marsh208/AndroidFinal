package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_selection.*
import kotlinx.android.synthetic.main.activity_stats.*
import java.util.*
import com.google.android.gms.ads.MobileAds;


class StatsActivity : AppCompatActivity() {

    lateinit var mAdView : AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdFailedToLoad(errorCode : Int) {
                Log.d("adError", errorCode.toString())
            }
        }




        winnerText.text = intent.extras?.get("winner").toString()

        team1TotalTosses.text = intent.extras?.get("team1TotalTosses").toString()
        team2TotalTosses.text = intent.extras?.get("team2TotalTosses").toString()

        team1ScoringProb.text = intent.extras?.get("scoreProb1").toString()
        team2ScoringProb.text = intent.extras?.get("scoreProb2").toString()

        team1MissedTosses.text = intent.extras?.get("missedTosses1").toString()
        team2MissedTosses.text = intent.extras?.get("missedTosses2").toString()

        team1HitProb.text = intent.extras?.get("hitProb1").toString()
        team2HitProb.text = intent.extras?.get("hitProb2").toString()

        team1CatchProb.text = intent.extras?.get("catchProb1").toString()
        team2CatchProb.text = intent.extras?.get("catchProb2").toString()

        displayFinalScores.text = intent.extras?.get("finalScores").toString()



    }
}