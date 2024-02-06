package com.bignerdranch.android.tsezar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView

fun CaesarCipher(word: String): List<String>{
    var result: List<String> = listOf<String>()
    var alphabet = "абвгдежзиклмнопрстуфхцчшщьыъэюя"
    for (i in 0 .. alphabet.length - 1){
        var inter = ""
        for (j in 0..word.length - 1){
            var k = 0
            while(word[j] != alphabet[k]){
                k++
            }
            inter += alphabet[(k + i) % 31]
        }
        result = result + inter
    }
    return result
}

class MainActivity : AppCompatActivity() {
    lateinit var result: MultiAutoCompleteTextView
    lateinit var button: Button
    lateinit var word: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        result = findViewById(R.id.multiAutoCompleteTextView)
        word = findViewById(R.id.editTextText)
        button.setOnClickListener(){
            if (word.text.toString() != ""){
                var prev:String = ""
                for(wor in CaesarCipher(word.text.toString())){
                    prev += wor +'\n'
                }
                result.setText(prev)
            }
            else{
                getString(R.string.NotText)
            }

        }
    }
}