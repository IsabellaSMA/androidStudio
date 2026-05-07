calc_media.kt

package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botao.setOnClickListener {
            val nome = binding.RecebeNome.text.toString()
            val nota_1 = binding.RecNota1.text.toString().toDouble()
            val nota_2 = binding.RecNota2.text.toString().toDouble()
            val media =(nota_1 + nota_2) / 2
            if (media >= 7) {
                binding.Saida.text = "O aluno "+nome+" foi aprovado com média " +media
            }
            else {
                binding.Saida.text = "O aluno "+nome+" foi reprovado com média " +media
            }

        }
    }
}