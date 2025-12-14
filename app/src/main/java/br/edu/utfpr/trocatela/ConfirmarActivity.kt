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
import br.edu.utfpr.trocatela.databinding.ActivityConfirmarBinding


class ConfirmarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmarBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityConfirmarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()

        binding.btConfirmarSMS.setOnClickListener {
            btnOnClickConfirmarSMS()
        }
    }

    fun initComponents() {

        // obtem os dados inputados na Activity Lancamento
        val cod  = intent.getIntExtra("cod", 0)
        val qtd = intent.getIntExtra("qtd", 0)
        val valor = intent.getDoubleExtra("valor",0.0)
        val valorTotal = intent.getDoubleExtra("valorTotal", 0.0)

        // preenche os campos com os dados retornados
        binding.tvCod.text = cod.toString()
        binding.tvQtd.text = qtd.toString()
        binding.tvValor.text = valor.toString()
        binding.tvAmountValue.text = valorTotal.toString()
    }

    fun btnOnClickConfirmarSMS(){
        val intent = Intent(Intent.ACTION_VIEW) // intent com ação generica que diz ao android que queremos visualizar algo

        val msg:String = "Cod:${binding.tvCod.text}, ${getString(R.string.etQuantity)}: ${binding.tvQtd.text}, ${getString(R.string.etUnitValue)}: ${binding.tvValor.text}, ${getString(R.string.etAmountHint)}: ${binding.tvAmountValue.text}" // mensagem de texto

        intent.setData(Uri.parse("sms:+5565996237611")) // Uniform Resource Identifier (URI). Informando para o android que queremos enviar uma mensagem de texto para o telefone
        intent.putExtra("sms_body",msg) // criamos o corpo da mensagem

        startActivity(intent) // iniciando a activity
    }
}