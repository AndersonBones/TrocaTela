package br.edu.utfpr.trocatela

import android.content.Intent
import android.net.Uri
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
        val intent = Intent(Intent.ACTION_VIEW) // intent com ação generica que diz ao android que queremos visualizar algo

        val msg:String = "Cod:${tvCod.text}, Qtd: ${tvQtd.text}, Valor: ${tvValor.text}"

        intent.setData(Uri.parse("sms:+5565996237611")) // Uniform Resource Identifier (URI). Informando para o android que queremos enviar uma mensagem de texto para o telefone
        intent.putExtra("sms_body",msg) // criamos o corpo da mensagem

        startActivity(intent) // iniciando a activity
    }
}