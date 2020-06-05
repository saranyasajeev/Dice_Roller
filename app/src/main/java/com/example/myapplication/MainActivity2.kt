package com.example.myapplication


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.R.id.Letsstart


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val Letsstart: Button = findViewById(Letsstart)
        Letsstart.setOnClickListener {
            Letsstart.setOnClickListener {

                Navigation.createNavigateOnClickListener(R.id.togame,null)
                MainActivity2()


            }
        }

        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }


    }
