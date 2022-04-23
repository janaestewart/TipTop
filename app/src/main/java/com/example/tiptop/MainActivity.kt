package com.example.tiptop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tiptop.databinding.ActivityMainBinding
import java.text.NumberFormat

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

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    fun calculateTip() {

        //grabbing the input cost of the user

        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()

        //added if statement to handle empty string to go with the new toDoubleOrNull
        if (cost == null) {
            binding.tipResult.text =""
            return
        }


        //grabbing which of the tip options is selected

        val selectId = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selectId){
            R.id.option_twenty_percent -> .20
            R.id.option_eighteen_percent -> .18
            else -> .15
        }

        //var over val because if rounded the tip value will/might change

        var tip = tipPercentage * cost

        //checking to see if the roundup switch is checked

        val roundUp = binding.roundUpSwitch.isChecked

        //round up function
        if(roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        //get the correct currency type

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        //displaying the tip result

        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
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