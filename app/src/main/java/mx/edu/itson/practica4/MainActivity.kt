package mx.edu.itson.practica4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight: EditText= findViewById(R.id.weight) as EditText
        val height: EditText= findViewById(R.id.height) as EditText
        val calcular: Button= findViewById(R.id.calcular)
        val imc: TextView= findViewById(R.id.imc)
        val range: TextView= findViewById(R.id.range)

        calcular.setOnClickListener{
            if(weight.getText().isNotEmpty() && height.getText().isNotEmpty()) {
                val peso = weight.getText().toString().toDouble()
                val estatura = height.getText().toString().toDouble()
                var calculoIMC= peso/(estatura*estatura)
                val numFormato= "%.2f".format(calculoIMC)

                imc.setText(numFormato)
                if(calculoIMC < 18.5){
                    range.setText("Bajo Peso")
                    range.setBackgroundResource(R.color.colorGreenish)
                }else if(calculoIMC <= 24.9){
                    range.setText("Normal")
                    range.setBackgroundResource(R.color.colorGreen)
                }else if(calculoIMC <= 29.9){
                    range.setText("Sobrepeso")
                    range.setBackgroundResource(R.color.colorYellow)
                }else if(calculoIMC <= 34.9){
                    range.setText("Obesidad Grado 1")
                    range.setBackgroundResource(R.color.colorOrange)
                }else if(calculoIMC <= 39.9){
                    range.setText("Obesidad Grado 2")
                    range.setBackgroundResource(R.color.colorRed)
                }else{
                    range.setText("Obesidad Grado 3")
                    range.setBackgroundResource(R.color.colorBrown)
                }
            }
        }

    }
}