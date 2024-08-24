package com.example.havagas

class Formulario (
    val nome: String,
    val email: String,
    val receberEmailCb: Boolean,
    val tipoTelefone: String,
    val telefone: String,
    val adicionarCelularCb: Boolean,
    val celular: String,
    val sexo: String,
    val dataNascimento: String,
    val formacao: String,
    val anoFormatura: String,
    val anoConclusao: String,
    val instituicao: String,
    val tituloMonografia: String,
    val orientador: String,
    val vagasInteresse: String
){
    override fun toString(): String {
        return "Nome: $nome\n" +
                "Email: $email\n" +
                "Receber Emails: $receberEmailCb\n" +
                "Tipo de Telefone: $tipoTelefone\n" +
                "Telefone: $telefone\n" +
                "Adicionar Celular: $adicionarCelularCb\n" +
                "Celular: ${if (adicionarCelularCb) celular else "Não fornecido"}\n" +
                "Sexo: $sexo\n" +
                "Data de Nascimento: $dataNascimento\n" +
                "Formação: $formacao\n" +
                "Ano de Formatura: $anoFormatura\n" +
                "Ano de Conclusão: $anoConclusao\n" +
                "Instituição: $instituicao\n" +
                "Título da Monografia: $tituloMonografia\n" +
                "Orientador: $orientador\n" +
                "Vagas de Interesse: $vagasInteresse"
    }
}