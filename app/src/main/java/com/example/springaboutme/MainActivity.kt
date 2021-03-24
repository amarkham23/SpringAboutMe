package com.example.springaboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.bio_text).visibility = View.INVISIBLE

        findViewById<Button>(R.id.name_button).setOnClickListener {
            addNickname(it)
        }

        findViewById<TextView>(R.id.intro_name).setOnClickListener {
            updateNickname(it)
        }


    }


    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.name_text)
        val nicknameTextView = findViewById<TextView>(R.id.intro_name)
        val textView = findViewById<TextView>(R.id.bio_text)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        textView.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.name_text)
        val doneButton = findViewById<Button>(R.id.name_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)



    }
}