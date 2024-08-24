package com.example.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)









        val adicionarCelularCb = amb.adicionarCelularCb
        val etCelular = amb.etCelular

        adicionarCelularCb.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                etCelular.visibility = View.VISIBLE
            } else {
                etCelular.visibility = View.GONE
            }
        }

        amb.salvaBt.setOnClickListener {
            val nome = amb.etNome.text.toString()
            val email = amb.etEmail.text.toString()
            val receberNotificacoesCb = amb.receberNotificacoes.isChecked
            val tipoTelefoneRg = if(amb.telefoneRg.checkedRadioButtonId == R.id.telComercial) "Comercial" else "Residencial"
            val telefone = amb.etTelefone.text.toString()
            val adicionarCelularCb = amb.adicionarCelularCb.isChecked
            val celular = amb.etCelular.text.toString()
            val sexo = if (amb.sexoRg.checkedRadioButtonId == R.id.masculinoRb) "Masculino" else "Feminino"
            val dataNascimento = amb.etDataNascimento.text.toString()
            val formacao = amb.formacaoSp.selectedItem.toString()
            val anoFormacao = amb.etAnoFormacao.text.toString()
            val anoConclusao = amb.etAnoConclusao.text.toString()
            val instituicao = amb.etInstituicao.text.toString()
            val tituloMonografia = amb.etTituloMonografia.text.toString()
            val orientador = amb.etOrientador.text.toString()
            val vagasInteresse = amb.etVagasInteresse.text.toString()

            val formulario = Formulario(nome, email, receberNotificacoesCb, tipoTelefoneRg, telefone,
                adicionarCelularCb, celular, sexo, dataNascimento, formacao, anoFormacao, anoConclusao,
                instituicao, tituloMonografia, orientador, vagasInteresse)

            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        amb.limparBt.setOnClickListener {
            amb.etNome.text.clear()
            amb.etEmail.text.clear()
            amb.receberNotificacoes.isChecked = false
            amb.telefoneRg.check(R.id.telComercial)
            amb.etTelefone.text.clear()
            amb.adicionarCelularCb.isChecked = false
            amb.etCelular.text.clear()
            amb.sexoRg.check(R.id.masculinoRb)
            amb.etDataNascimento.text.clear()
            amb.formacaoSp.setSelection(0)
            amb.etAnoFormacao.text.clear()
            amb.etAnoConclusao.text.clear()
            amb.etInstituicao.text.clear()
            amb.etTituloMonografia.text.clear()
            amb.etOrientador.text.clear()
            amb.etVagasInteresse.text.clear()
        }


        val etAnoFormacao = amb.etAnoFormacao;
        val etAnoConclusao = amb.etAnoConclusao;
        val etInstituicao = amb.etInstituicao;
        val etTituloMonografia = amb.etTituloMonografia;
        val etOrientador = amb.etOrientador;

        amb.formacaoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selFormacao = parent?.getItemAtPosition(position).toString()

                if (selFormacao == "Fundamental" || selFormacao == "Médio") {
                    etAnoFormacao.visibility = View.VISIBLE
                }
                else if(selFormacao == "Graduação" || selFormacao == "Especialização") {
                    etAnoFormacao.visibility = View.GONE
                    etAnoConclusao.visibility = View.VISIBLE
                    etInstituicao.visibility = View.VISIBLE
                }
                else if(selFormacao == "Mestrado" || selFormacao == "Doutorado"){
                    etAnoFormacao.visibility = View.GONE
                    etAnoConclusao.visibility = View.VISIBLE
                    etInstituicao.visibility = View.VISIBLE
                    etTituloMonografia.visibility = View.VISIBLE
                    etOrientador.visibility = View.VISIBLE
                }
                else{
                    etAnoFormacao.visibility = View.GONE
                    etAnoConclusao.visibility = View.GONE
                    etInstituicao.visibility = View.GONE
                    etTituloMonografia.visibility = View.GONE
                    etOrientador.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //NSA
            }



        }
    }
}