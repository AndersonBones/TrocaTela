package br.edu.utfpr.trocatela

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ConfirmarActivity : AppCompatActivity() {

    private lateinit var tvCod: TextView
    private lateinit var tvQtd: TextView
    private lateinit var tvValor: TextView
    private lateinit var btConfirmarSMS: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()

        btConfirmarSMS.setOnClickListener {
            btnOnClickConfirmarSMS()
        }
    }

    fun initComponents() {
        tvCod = findViewById(R.id.tvCod)
        tvQtd = findViewById(R.id.tvQtd)
        tvValor = findViewById(R.id.tvValor)
        btConfirmarSMS = findViewById(R.id.btConfirmarSMS)

        val cod  = intent.getIntExtra("cod", 0)
        val qtd = intent.getIntExtra("qtd", 0)
        val valor = intent.getIntExtra("valor",0)

        tvCod.text = cod.toString()
        tvQtd.text = qtd.toString()
        tvValor.text = valor.toString()
    }

    fun btnOnClickConfirmarSMS(){

    }
}