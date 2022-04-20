import kotlin.system.exitProcess

fun main() {
    menu()
}

fun menu() {

    do {

        println("|--*--*--Bem vindo ao sistema escolar de SymCity *--*--|")
        println("|        Por favor, digite a opção desejada:           |")
        println("|------------------------------------------------------|")
        println("|--------------01 - Inserir notas do aluno:------------|")
        println("|--------------02 - Sair ------------------------------|")
        println("|------------------------------------------------------|")
        val opcao = readln().toInt()

        mostrarResultadosMenu(opcao)
    } while (true)

}

fun notasAlunos() {
    val notas = DoubleArray(4)
    notas.forEachIndexed { i, _ ->
        println("Informe a ${(i + 1)}ª nota do Aluno:")
        notas[i] = readln().toDouble()

        validarNotas(notas)
    }

    println("A média semestral do aluno é = ${(mediaAlunos(notas))}")

}

fun validarNotas(notas: DoubleArray) {

    notas.forEachIndexed { i, _ ->

        if (notas[i] !in -0.0..10.0) {
            println("Nota inválida. Digite novamente")
            println("Informe a ${(i + 1)} nota do Aluno:")
            notas[i] = readln().toDouble()
        }
    }
}

fun mediaAlunos(notas: DoubleArray): Double {
    var soma = 0.0

    notas.forEachIndexed { i, _ ->
        if (notas[i] in 0.0..10.0) {
            soma += notas[i]

        }
    }
    return soma / notas.size
}

fun mostrarResultadosMenu(opcao: Int) {

    when (opcao) {
        1 -> println(notasAlunos())
        2 -> {
            println("Obrigada por usar nosso sistema :D")
            exitProcess(0)
        }
        else -> println("Opção inválida")
    }
}








