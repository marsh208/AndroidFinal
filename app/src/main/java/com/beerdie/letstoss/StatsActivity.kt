package com.beerdie.letstoss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_stats.*
import com.google.android.gms.ads.MobileAds;


class StatsActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    private lateinit var gifViewModel: GifViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        gifViewModel = ViewModelProviders.of(this).get(GifViewModel::class.java)
        gifViewModel.getRandomGif("beer").observe(this,
            androidx.lifecycle.Observer { loadGif(it) })

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

        sinks1.text = intent.extras?.get("sinks1").toString()
        sinks2.text = intent.extras?.get("sinks2").toString()

        team1StatColumn.text = intent.extras?.get("teamName1").toString()
        team2StatColumn.text = intent.extras?.get("teamName2").toString()



        displayFinalScores.text = intent.extras?.get("finalScores").toString()



    }

    private fun loadGif(gif: Gif){
        Glide.with(this)
            .load(gif.url)
            .into(statsGif)
    }
}