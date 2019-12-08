package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_selection.*
import kotlinx.android.synthetic.main.activity_stats.*
import java.util.*
import android.view.animation.AnimationUtils


class GameActivity : AppCompatActivity() {

    private fun getTeam1Name() = intent.extras?.get("team1Name").toString()
    private fun getTeam2Name() = intent.extras?.get("team2Name").toString()



    var currentIndex : Int = 0

    var team1Score : Int = 0
    var team2Score : Int = 0

    var team1Catches: Int = 0
    var team2Catches: Int = 0

    var team1TotalTosses : Int = 0
    var team2TotalTosses : Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var playerArray : Array<String> = arrayOf(getTeam1Name() + ": Player 1",getTeam1Name() + ": Player 2",getTeam2Name() + ": Player 1",getTeam2Name() + ": Player 2")

        displayTeam.text = playerArray[currentIndex]

        scoreButton.setOnClickListener{
            var animation1 = AnimationUtils.loadAnimation(this@GameActivity, R.anim.mixed)
            scoreButton.startAnimation(animation1)
            if(currentIndex == 0 || currentIndex == 1)
            {

                team1TotalTosses++
                team1Score++

                Team1score.text = team1Score.toString()

                if(team1Score >= 11)
                {
                    generateStats(getTeam1Name())
                }
            }
            else
            {
                team2TotalTosses++
                team2Score++

                Team2score.text = team2Score.toString()

                if(team2Score >= 11)
                {
                    generateStats(getTeam2Name())
                }
            }


            if (currentIndex == 3)
            {
                currentIndex = 0
            }
            else
            {
                currentIndex++
            }

            if(team1Score < 11 && team2Score < 11)
            {
                displayTeam.text = playerArray[currentIndex]
            }


        }

        catchButton.setOnClickListener{
            var animation2 = AnimationUtils.loadAnimation(this@GameActivity, R.anim.magnify)
            catchButton.startAnimation(animation2)
            if(currentIndex == 0 || currentIndex == 1)
            {
                team1TotalTosses++
                team2Catches++
            }
            else
            {
                team2TotalTosses++
                team1Catches++
            }

            if (currentIndex == 3)
            {
                currentIndex = 0
            }
            else
            {
                currentIndex++
            }
            displayTeam.text = playerArray[currentIndex]
        }

        missButton.setOnClickListener{
            var animation3 = AnimationUtils.loadAnimation(this@GameActivity, R.anim.zoom)
            missButton.startAnimation(animation3)
            if(currentIndex == 0 || currentIndex == 1)
            {
                team1TotalTosses++
            }
            else
            {
                team2TotalTosses++
            }

            if (currentIndex == 3)
            {
                currentIndex = 0
            }
            else
            {
                currentIndex++
            }
            displayTeam.text = playerArray[currentIndex]
        }



    }

    private fun generateStats(winner : String) {
        //score, total tosses, scoring prob = score/totalTosses, missed tossess = totalTosses-catches-points, hit % = catches+points/totalTosses, team1catches = team2tosses-misses-scores/team2tosses
        val finalScores = team1Score.toString() + " : " + team2Score.toString()
        val scoreProb1 = "%.2f".format((team1Score.toDouble()/team1TotalTosses)*100) + "%"
        val scoreProb2 = "%.2f".format((team2Score.toDouble()/team2TotalTosses)*100) + "%"

        val missedTosses1 = (team1TotalTosses - team2Catches - team1Score)
        val missedTosses2 = (team2TotalTosses - team1Catches - team2Score)

        val hitProb1 = "%.2f".format(((team2Catches.toDouble() + team1Score)/team1TotalTosses)*100) + "%"
        val hitProb2 = "%.2f".format(((team1Catches.toDouble() + team2Score)/team2TotalTosses)*100) + "%"

        val catchProb1 = "%.2f".format((team1Catches.toDouble()/(team2TotalTosses - missedTosses2)*100)) + "%"
        val catchProb2 = "%.2f".format((team2Catches.toDouble()/(team1TotalTosses- missedTosses1)*100)) + "%"


        startActivity(Intent(this, StatsActivity::class.java).apply {
            putExtra(
                "winner",
                winner
            )
            putExtra(
                "team1TotalTosses",
                team1TotalTosses
            )
            putExtra(
                "team2TotalTosses",
                team2TotalTosses
            )
            putExtra(
                "scoreProb1",
                scoreProb1
            )
            putExtra(
                "scoreProb2",
                scoreProb2
            )
            putExtra(
                "missedTosses1",
                missedTosses1
            )
            putExtra(
                "missedTosses2",
                missedTosses2
            )
            putExtra(
                "hitProb1",
                hitProb1
            )
            putExtra(
                "hitProb2",
                hitProb2
            )
            putExtra(
                "catchProb1",
                catchProb1
            )
            putExtra(
                "catchProb2",
                catchProb2
            )
            putExtra(
                "finalScores",
                finalScores
            )
        })


    }


}