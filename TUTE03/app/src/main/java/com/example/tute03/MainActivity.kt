package com.example.tute03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.tute03.Models.Calculator

class MainActivity : AppCompatActivity() {

    //global variable, lateinit for values assign later, get form editText
    lateinit var editNumber1:EditText
    lateinit var editNumber2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get values by id and assigning to variables
        editNumber1 = findViewById(R.id.editNumber1)
        editNumber2 = findViewById(R.id.editNumber2)



    }

    fun buttonClick(v:View){
        //define initial value to answer
        var ans = 0.0

        //pass the parameters
        val calculator = Calculator(
            editNumber1.text.toString().toDouble(),
            editNumber2.text.toString().toDouble()
        )

        //get id and accourding to id calling functions
        when(v.id){

            R.id.btnAdd         -> ans = calculator.add()
            R.id.btnSubtract    -> ans = calculator.subtract()
            R.id.btnMultiply    -> ans = calculator.multiply()
            R.id.btnDivide      -> ans = calculator.divide()

        }

        //display a toast msg
        Toast.makeText(this, "Answer = $ans", Toast.LENGTH_LONG).show()
    }



}
