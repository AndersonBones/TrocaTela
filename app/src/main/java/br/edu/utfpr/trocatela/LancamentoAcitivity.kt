package br.edu.utfpr.trocatela

import android.content.Intent
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

    lateinit var etQtd: EditText
    lateinit var etValor: EditText
    lateinit var etCod: EditText
    lateinit var btConfirmar: Button
    lateinit var btListar:Button

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
            btOnClickConfirmar()
        }

    }
    
    private fun initComponents(){
        etQtd = findViewById(R.id.etQtd)
        etValor = findViewById(R.id.etValor)
        etCod = findViewById(R.id.etCod)
        btConfirmar = findViewById(R.id.btConfirmar)
        btListar = findViewById(R.id.btListar)
        
    }
    private fun btOnClickConfirmar(){
        val intent = Intent(this, ConfirmarActivity::class.java)
        val cod = etCod.text.toString().toIntOrNull()
        val qtd = etQtd.text.toString().toIntOrNull()
        val valor = etValor.text.toString().toIntOrNull()

        if(cod == null || qtd == null || valor == null){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }else{
            intent.putExtra("cod", cod)
            intent.putExtra("qtd", qtd)
            intent.putExtra("valor", valor)
            startActivity(intent)
        }



    }

    private fun btOnClickcListar(){

    }
}