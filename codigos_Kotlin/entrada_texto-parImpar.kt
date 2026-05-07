// codigo do primeiro programa de par ou impar feito no android studio. Onde havia duas entradas de texto

package com.example.parimpar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.parimpar.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.jogar.setOnClickListener {
            val nome = binding.NomeJog.text.toString()
            val jogada = binding.Jogada.text.toString()
            val num = binding.Numero.text.toString().toInt()
            val comp = Random.nextInt(0, 10)
            val soma = num + comp
            if (jogada == "par" && soma % 2 == 0 || jogada == "impar" && soma % 2 == 1) {
                binding.Saida.text = "Você Venceu"
            }
            else {
                binding.Saida.text = "Você Perdeu"
            }
        }

        }
    }