package com.zebrano.pifagortheorem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zebrano.pifagortheorem.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var bindingObj : ActivityMainBinding
    var a : Int = 0
    var b : Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingObj = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingObj.root)

        bindingObj.bCalculate.setOnClickListener {
            if(!isEmpty()){
                a = bindingObj.aSide.text.toString().toInt()
                b = bindingObj.bSide.text.toString().toInt()
                val c = a*a+b*b
                bindingObj.tvRes.text = "c * c = a * a + b * b = $a * $a + $b * $b = $c\n c = ${sqrt(c.toFloat())}"
            } else {
                showToast(getString(R.string.isEmpty))
            }
        }
    }

    private fun showToast(string: String) {
        val toastDuration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext,  string, toastDuration)
        toast.show()
    }

    private fun isEmpty() : Boolean {
        var b = false
        if (bindingObj.aSide.text?.isEmpty() == true){
            bindingObj.aSide.error = getString(R.string.isEmpty)
            b = true
        }
        if (bindingObj.bSide.text?.isEmpty() == true) {
            bindingObj.bSide.error = getString(R.string.isEmpty)
            b = true
        }
        if (!b)
            return false
        else return true
    }


}