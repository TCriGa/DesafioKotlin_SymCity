import kotlin.system.exitProcess


fun main() {
    boasVindas()
    do {

        val notas1 = notasAlunos()
        val resultado = mediaAlunos(notas1)
        mostrarMenu(resultado)
    } while (true)
}

fun boasVindas() {
    println("|--*--*  Bem vindo ao sistema escolar de SymCity *--*--|")
    println("|--------------Inserir notas do aluno:-----------------|")
    println("|------------------------------------------------------|")
}

fun menu() {
    println("|--*--*  Bem vindo ao sistema escolar de SymCity *--*--|")
    println("|        Por favor, digite a opção desejada:           |")
    println("|------------------------------------------------------|")
    println("|--------------01 - Inserir notas do aluno:------------|")
    println("|--------------02 - Mostrar média do aluno: -----------|")
    println("|--------------03 - Sair ------------------------------|")
    println("|------------------------------------------------------|")

}

fun notasAlunos(): DoubleArray {

    val notas = DoubleArray(4)
    notas.forEachIndexed { i, _ ->
        notas[i] = validarNotas(i)
    }

    return notas
}

    fun validarNotas(i: Int): Double {
        println("Informe a ${(i + 1)}ª nota do Aluno:")
        var nota = readln().toDouble()


        while (nota !in 0.0..10.0) {
            println("Nota inválida. Digite novamente")
            println("Informe a ${(i + 1)} nota do Aluno:")
            nota = readln().toDouble()
        }
        return nota
    }

fun mediaAlunos(notas: DoubleArray): String {
    var soma = 0.0
    notas.forEachIndexed { i, _ ->
        soma += notas[i]

    }
    println(" A média do Aluno é ${soma / notas.size}")
    return " A média do Aluno é ${soma / notas.size}"
}


fun mostrarMenu(resultado: String) {
    menu()
    when (readln().toInt()) {
        1 -> println("Novo calculo: ")
        2 -> {
            println(resultado)
            mostrarMenu(resultado)
        }
        3 -> { println("Obrigada por usar nosso sistema :D")
            exitProcess(0)
        }

        else -> {
            println("Opção inválida")
            mostrarMenu(resultado)
        }
    }
}








