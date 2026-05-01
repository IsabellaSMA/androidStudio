package com.example.parimpar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configuração para as barras do sistema (status bar/navigation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Referenciar os elementos do layout XML
        val campoJogada = findViewById<EditText>(R.id.jogada)
        val campoNum = findViewById<EditText>(R.id.num)
        val botaoJogar = findViewById<Button>(R.id.jogar)
        val textoResultado = findViewById<TextView>(R.id.resultado)

        // 2. Configurar o que acontece quando clica no botão
        botaoJogar.setOnClickListener {

            // Pega o que o usuário escreveu
            val escolhaUsuario = campoJogada.text.toString().trim()
            val numeroUsuario = campoNum.text.toString().toIntOrNull() ?: 0

            // O computador escolhe um número de 0 a 10
            val numeroApp = (0..10).random()
            val soma = numeroUsuario + numeroApp

            // Verifica se a soma é Par ou Ímpar
            val resultadoEhPar = soma % 2 == 0
            val resultadoTexto = if (resultadoEhPar) "PAR" else "ÍMPAR"

            // Lógica para saber se o jogador venceu
            val venceu = (escolhaUsuario.equals("Par", ignoreCase = true) && resultadoEhPar) ||
                    (escolhaUsuario.equals("Ímpar", ignoreCase = true) && !resultadoEhPar ||
                            escolhaUsuario.equals("Impar", ignoreCase = true) && !resultadoEhPar)

            // 3. Exibir o resultado na tela
            if (venceu) {
                textoResultado.text = "Você Venceu! \nSua soma deu $soma ($resultadoTexto). \nO app jogou $numeroApp."
            } else {
                textoResultado.text = "Você Perdeu! \nSua soma deu $soma ($resultadoTexto). \nO app jogou $numeroApp."
            }
        }
    }
}