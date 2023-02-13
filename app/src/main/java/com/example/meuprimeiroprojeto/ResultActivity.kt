package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* TABELA IMC
        MENOR QUE 18,5             ABAIXO DO PESO 0
        ENTRE 18,5 E 24,9           NORMAL 0
        ENTRE 25,0 E 29,9           SOBRE PESO  I
        ENTRE 30,0 E 39,9           OBESIDADE   II
        MAIOR QUE 40,0              OBESIDADE GRAVE III
         */
        val classificacao = if (result < 18.5f) {
            "Abaixo do normal\n" +
                    "Procure um médico. Algumas pessoas têm um baixo peso por características do seu organismo e tudo bem. Outras podem estar enfrentando problemas, como a desnutrição."

        } else if (result >= 18.5f && result <= 24.9f) {
            "Normal\n" +
                    "Que bom que você está com o peso normal! E o melhor jeito de continuar assim é mantendo um estilo de vida ativo e uma alimentação equilibrada."

        } else if (result >= 25f && result <= 29.9) {
            "Sobrepeso\n" +
                    "Ele é, na verdade, uma pré-obesidade e muitas pessoas nessa faixa já apresentam doenças associadas, como diabetes e hipertensão. Importante rever hábitos."
        } else {
            "Obesidade\n" +
                    "grau III\n" +
                    "Aqui o sinal é vermelho, com forte probabilidade de já existirem doenças muito graves associadas. O tratamento deve ser ainda mais urgente."
        }
        tvClassificacao.text = getString(R.string.message_classificacao,classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}
