package br.edu.utfpr.trocatela

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btListar: Button



    override fun onCreate(savedInstanceState: Bundle?) { // cria a activity
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main) // carrega especificamente a activity_main.xml
        val mainView = findViewById<View>(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponent() // inicializa os componentes da activity

        btListar.setOnClickListener { // adiciona um listener ao botão
            switchActivity()
        }
    }



    private fun initComponent(){
        btListar = findViewById(R.id.btListar)
    }

    private fun switchActivity(){

        val intent = Intent(this, LancamentoActivity::class.java) // cria uma intenção para a activity LancamentoAcitivity

        startActivity(intent) // inicia a intenção

    }


}