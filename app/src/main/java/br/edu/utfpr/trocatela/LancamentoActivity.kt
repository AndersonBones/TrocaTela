package br.edu.utfpr.trocatela

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.trocatela.databinding.ActivityLancamentoActivityBinding
import java.text.NumberFormat
import java.util.Locale

class LancamentoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLancamentoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLancamentoActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btConfirmar.setOnClickListener{
            btOnClickConfirmar()
        }

        binding.btListar.setOnClickListener{
            btOnClickcListar()
        }

        binding.etValor.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP){
                val qtd = binding.etQtd.text.toString().toIntOrNull()
                val valor = binding.etValor.text.toString().toDoubleOrNull()

                if(qtd != null && valor != null){
                    val valor_total = (qtd * valor)

                    val formattedValue = NumberFormat.getCurrencyInstance()

                    binding.tvAmountValue.text = formattedValue.format(valor_total)
                }
                return@setOnKeyListener true
            }

            return@setOnKeyListener false
        }

        binding.etQtd.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP){
                val qtd = binding.etQtd.text.toString().toIntOrNull()
                val valor = binding.etValor.text.toString().toDoubleOrNull()

                if(qtd != null && valor != null){
                    val valor_total = (qtd * valor)

                    val formattedValue = NumberFormat.getCurrencyInstance()

                    binding.tvAmountValue.text = formattedValue.format(valor_total)
                }
                return@setOnKeyListener true
            }

            return@setOnKeyListener false
        }

    }
    

    private fun btOnClickConfirmar(){
        val intent = Intent(this, ConfirmarActivity::class.java) // cria intençao para pular desse contexto para ConfirmarActivity

        val cod = binding.etCod.text.toString().toIntOrNull()
        val qtd = binding.etQtd.text.toString().toIntOrNull()
        val valor = binding.etValor.text.toString().toDoubleOrNull()
        val valorTotal: Double = if (qtd != null && valor != null) {
            qtd * valor
        } else {
            0.0
        }


        if(cod == null || qtd == null || valor == null || valorTotal == null){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }else{
            // salva dados e envia para a proxima Activity
            intent.putExtra("cod", cod)
            intent.putExtra("qtd", qtd)
            intent.putExtra("valor", valor)
            intent.putExtra("valorTotal", valorTotal)
            startActivity(intent) // inicia a Activity
        }

    }

    private fun btOnClickcListar(){
        val intent = Intent(this, ListarActivity::class.java) // cria uma intent explicita => ir para a ListarActivity
        getResult.launch(intent) // incia a intent e espera um retorno

    }


    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->  // chamamos um contrato que define o tipo de operação. A operação é iniciar uma activity e esperar um resultado.
        if(result.resultCode == RESULT_OK){ // result contem a intent com os resultados que foram lançados na activity anterior (ListarActivity)
            val cod: Int? = result.data?.getIntExtra("cod", 0) // lançamos a intent com um resultCode e um valor com chave "cod"
            binding.etCod.setText(cod.toString()) // definimos o texto do EditText como o valor retornado pela intent

        }

        if(result.resultCode == RESULT_CANCELED){

            Toast.makeText(this, "Nenhum produto selecionado", Toast.LENGTH_LONG).show()

        }
    }
}