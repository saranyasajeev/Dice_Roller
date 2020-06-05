package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var TAG:String="MainActivity"
    var randomInt:Int=0
    lateinit var diceImage: ImageView
    var game_valueA:Int =0
    var game_valueB:Int =0
    var active_playerA:Boolean=true
    var active_playerB:Boolean=false
    var game_point:Int=100
    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
    var gameendmsg:String? =null
    var gameendmsgdefault:String ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.isEnabled=false


        Start.setOnClickListener {
            rollButton.isEnabled=true
            game_valueA=0
            game_valueB=0
            gamewinmsg.text=null
            tvGamePointA.text="0"
            tvGamePointB.text="0"
            active_playerA=true
            active_playerB=false
            diceImage.setImageResource(R.drawable.dice_1)
        }
        rollButton.setOnClickListener {
            rollButton.setOnClickListener {
                rollDice()
            }
        }
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {

         randomInt = Random().nextInt(6) + 1

        val drawableResource = when (randomInt) {
            1 -> {
                  R.drawable.dice_1

            }
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        if(active_playerA){
                            game_valueA+=randomInt
                            tvGamePointA.text=game_valueA.toString()
                            active_playerA=false
                            active_playerB = true

            if(game_valueA>=100){
                gameendmsgdefault= resources.getText(R.string.gameovermsg).toString()
                gameendmsg= gameendmsgdefault +"Player A"
                gamewinmsg.text= gameendmsg!!.toEditable()

                roll_button.isEnabled=false
            }
        }
        else {
            game_valueB +=randomInt
            tvGamePointB.text=game_valueB.toString()
            active_playerB = false
            active_playerA = true

            if (game_valueB>=100){
                gameendmsgdefault= resources.getText(R.string.gameovermsg).toString()

                gameendmsg=gameendmsgdefault  + "Player B"
                gamewinmsg.text= gameendmsg!!.toEditable()
                roll_button.isEnabled=false
            }
            }

        }
    }

