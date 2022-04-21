package com.example.tiptop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tiptop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //This line declares a top-level variable in the class for the binding object.
    // It's defined at this level because it will be used across multiple methods
    // in MainActivity class.
    // The lateinit keyword is something new. It's a promise that your code will initialize the
    // variable before using it. If you don't, your app will crash


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //This line initializes the binding object which you'll use to
        // access Views in the activity_main.xml layout.

        binding = ActivityMainBinding.inflate(layoutInflater)

        //Set the content view of the activity. Instead of passing the resource ID of the layout,
        // R.layout.activity_main, this specifies the root of the hierarchy of views in your app,
        // binding.root.

        setContentView(binding.root)
    }
}

// Old way with findViewById()
//val myButton: Button = findViewById(R.id.my_button)
//myButton.text = "A button"

// Better way with view binding
//val myButton: Button = binding.myButton
//myButton.text = "A button"

// Best way with view binding and no extra variable
//s