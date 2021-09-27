package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var myRV : RecyclerView
    lateinit var clRoot : ConstraintLayout
    lateinit var addText : EditText
    lateinit var itemList : ArrayList<String>
    lateinit var addButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Snackbar code
        var myLayout = findViewById<ConstraintLayout>(R.id.clMain)
        Snackbar.make(myLayout, "Hello there, welcome to my app!", Snackbar.LENGTH_LONG).show()

        //Recycler View code
         clRoot = findViewById(R.id.clMain)
         addText = findViewById(R.id.list)
         addButton = findViewById(R.id.bAdd)
         itemList = ArrayList()
         itemList.add("Shopping")

         myRV = findViewById<RecyclerView>(R.id.rvMain )
         myRV.adapter = RecyclerViewAdapter(itemList)
        myRV.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {(makeAlist())}
    }

    private fun makeAlist(){

        var dailyTask = addText.text.toString()
        itemList.add(dailyTask)
    }
}