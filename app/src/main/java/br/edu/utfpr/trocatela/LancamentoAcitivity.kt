package br.edu.utfpr.trocatela

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LancamentoAcitivity : AppCompatActivity() {

    lateinit var etQtde: EditText
    lateinit var etValor: EditText
    lateinit var etCod: EditText
    lateinit var btConfirmar: Button
    lateinit var btLimpar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lancamento_acitivity)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()

        btConfirmar.setOnClickListener{
            btOnClickCalcular()
        }

        btLimpar.setOnLongClickListener{
            btOnClickcLimpar()
            Toast(this).setText("Limpar dados")
            false

        }
        



    }
    
    private fun initComponents(){
        etQtde = findViewById(R.id.etQtde)
        etValor = findViewById(R.id.etValor)
        etCod = findViewById(R.id.etCod)
        btConfirmar = findViewById(R.id.btConfirmar)
        btLimpar = findViewById(R.id.btLimpar)
        
    }
    private fun btOnClickCalcular(){
        var result: Int = etQtde.text.toString().toInt() * etValor.text.toString().toInt()
        Toast(this).setText("O resultado é: $result")
    }

    private fun btOnClickcLimpar(){
        etValor.setText("")
        etQtde.setText("")
        etCod.setText("")
        etCod.requestFocus()
    }
}