package br.edu.utfpr.trocatela

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.trocatela.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) { // cria a activity
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater) // inflando os componentes da activity
        setContentView(binding.root) // setando o componente raiz como nossa view principal

        val mainView = findViewById<View>(R.id.main)


        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btLancamento.setOnClickListener { // adiciona um listener ao botão
            switchActivity()
        }
    }





    private fun switchActivity(){

        // a inteção é pular do contexto atual para LancamentoActivity
        val intent = Intent(this, LancamentoActivity::class.java) // cria uma intenção para a activity LancamentoAcitivity

        startActivity(intent) // inicia a intenção

    }


}