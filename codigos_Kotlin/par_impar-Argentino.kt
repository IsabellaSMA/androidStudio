// codigo da segunda versão de Par ou Impar, onde o Jogador apenas escree o nome e aperta botões 'Par' ou 'Impar' e jogar.. matéria de funções

package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPar.setOnClickListener {
            jogar("PAR")
        }

        binding.btnImpar.setOnClickListener {
            jogar("IMPAR")
        }
    }

    
    private fun jogar(escolhaUsuario: String) {
        val numeroUsuario = binding.edtNumero.text.toString()

        if (numeroUsuario.isEmpty()) {
            binding.txtResultado.text = "Digite um número!"
            return
        }

        val numUser = numeroUsuario.toInt()
        val numComputador = Random.nextInt(0, 11)

        val soma = numUser + numComputador
        val resultado = if (soma % 2 == 0) "PAR" else "IMPAR"

        val venceu = resultado == escolhaUsuario

        binding.txtResultado.text = """ 
            Você jogou: $numUser
            Computador: $numComputador
            Soma: $soma ($resultado)
            
            ${if (venceu) "Você ganhou!" else "Você perdeu!"}
        """.trimIndent()
    }
}