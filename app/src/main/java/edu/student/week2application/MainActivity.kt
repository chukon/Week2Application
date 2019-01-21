package edu.student.week2application

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set variables
        var txtName = findViewById<EditText>(R.id.txtName)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        var Show = findViewById<TextView>(R.id.txtShow)

        //set focus to txtName at load time of app
        txtName.requestFocus()

        //when user taps submit it takes name entered and puts in txtShow TextView
        //clears txtName
        //hide keyboard
        btnSubmit.setOnClickListener{
            val userinput = txtName.text.toString()
            Show.setText(userinput)
            txtName.setText("")
            hideKeyboard() //Need to create function to clear keyboard
        }
    }

// function to hide keyboard goes right before the last right bracket of Class MainActivity
//import android.content.Context
//import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}
