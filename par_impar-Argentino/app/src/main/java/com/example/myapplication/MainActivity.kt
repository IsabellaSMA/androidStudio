package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPar.setOnClickListener {
            jogar("PAR")
        }
        binding.btnImpar.setOnClickListener {
            jogar("IMPAR")
        }
    }

    private fun jogar(escolhaUsuario: String){
        val numeroUsuario = binding.edtNumero.text.toString()

        if(numeroUsuario.isEmpty()){
            binding.txtResultado.text="Digite um numero!!!"
            return
        }
        val numUser=numeroUsuario.toInt()
        val numComputador = Random.nextInt(0,11)

        val soma=numUser +numComputador
        val resultado = if (soma%2==0) "PAR" else "IMPAR"

        val venceu = resultado == escolhaUsuario

        binding.txtResultado.text="""
            Você jogou: $numUser
            Computador escolheu: $numComputador
            Soma: $soma
            
            ${if (venceu) "Voce ganhou" else "Você perdeu"}"""
            .trimIndent()
    }
}