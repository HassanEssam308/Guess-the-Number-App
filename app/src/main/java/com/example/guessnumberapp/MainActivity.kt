package com.example.guessnumberapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var btnNewGame:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        startGame()

        btnNewGame=findViewById(R.id.Main_Btn_NewGame)

        btnNewGame.setOnClickListener{
            startGame()

        }

    }
    fun startGame(){

        val bundle= Bundle()
        bundle.putInt("randomNumber_Key",Random.nextInt(1,9))
        val numbersFragment=NumbersFragment()
        numbersFragment.arguments=bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.Main_FL_ShowNumbers,numbersFragment).commit()
    }
}