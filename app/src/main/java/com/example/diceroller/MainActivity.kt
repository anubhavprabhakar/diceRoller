package com.example.diceroller

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// activity allowing user to roll a dice and display the rolled number on screen
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        //action performed when Roll button tapped
        rollButton.setOnClickListener { rollDice() }

        //Do a diceroll when app starts
        rollDice()
    }

    // function to roll the dice, and display the result
    private fun rollDice() {
        val dice = Dice(6) //creating dice object, passing 6 sides as parameter


        //finding ImageView_1 in layout
        val diceImage1: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        var drawableResource = R.drawable.dice_1

        //logic to roll dice when requested, and set drawable resource to the image of number rolled
        fun rolled(){
            drawableResource = when (dice.roll()) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        }

        //rolling for dice 1
        rolled()
        //setting proper first dice image, and content description
        diceImage1.setImageResource(drawableResource)
        //diceImage1.contentDescription = diceRoll.toString()

        //rolling for dice 2
        rolled()
        diceImage2.setImageResource(drawableResource)
        //diceImage2.contentDescription = diceRoll.toString()



    }
}

//Dice class
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()   //generating random number from 1 to 6 and returning
    }
}