enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} matriculado na formação $nome.")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo ${conteudo.nome} adicionado na formação $nome.")
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        conteudos.forEach {
            println(" - ${it.nome} (${it.duracao} minutos)")
        }
    }
}

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")
    val usuario3 = Usuario("Pedro")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 30)
    val conteudo2 = ConteudoEducacional("Classes e Objetos", 45)
    val conteudo3 = ConteudoEducacional("Funções e Lambdas", 60)

    val formacao1 = Formacao("Desenvolvimento Android", Nivel.INTERMEDIARIO)
    formacao1.adicionarConteudo(conteudo1)
    formacao1.adicionarConteudo(conteudo2)
    formacao1.adicionarConteudo(conteudo3)

    formacao1.listarConteudos()

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)

    val formacao2 = Formacao("Desenvolvimento Web", Nivel.BASICO, mutableListOf(conteudo1, conteudo3))
    formacao2.adicionarConteudo(conteudo2)

    formacao2.listarConteudos()

    formacao2.matricular(usuario3)
}
