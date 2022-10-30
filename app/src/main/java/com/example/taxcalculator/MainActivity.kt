package com.example.taxcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spSelect:Spinner = findViewById(R.id.spSelect)
        val edPrice:EditText = findViewById(R.id.edPrice)
        val calcBtn:Button = findViewById(R.id.calcBtn)
        val resultTv:TextView = findViewById(R.id.resultTv)
        var flag = "citizen"
        var options = arrayOf("citizen", "tourist")
        spSelect.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        spSelect.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        calcBtn.setOnClickListener{
            view ->
            val x = edPrice.text.toString().toDouble()
            if (flag == "tourist") {
                resultTv.text = calcTourist(x).toString()
            } else {
                resultTv.text = calcCitizen(x).toString()
            }
        }
    }
    public fun calcTourist(x:Double):Double {
        return x * 1.04; // 4%
    }
    public fun calcCitizen(x:Double):Double {
        return x * 1.14; // 14%
    }
}

