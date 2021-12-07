package com.example.gastosdeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity() : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if(id == R.id.btnCalcular){
            calcular()
        }
    }
    fun calcular(){
        if(validar()) {
            try {
                val distancia = txtDistancia.text.toString().toFloat()
                val preco = txtPreco.text.toString().toFloat()
                val autonomia = txtAutonomia.text.toString().toFloat()

                val total = (distancia * preco) / autonomia
                lblTotal.text = "R$ ${"%.2f".format(total)}"
            }catch (nfe: NumberFormatException){
                Toast.makeText(this, "Autonomia invalida", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
        }
    }
    private fun validar() : Boolean = (txtDistancia.text.toString() != ""
            && txtPreco.text.toString() != ""
            && txtAutonomia.text.toString() != ""
            && txtAutonomia.text.toString() != "0")

}