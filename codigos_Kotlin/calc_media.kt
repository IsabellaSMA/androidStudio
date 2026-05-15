fun main() {
    print("Digite seu nome: ")
    val nome = readln()
    println("Oi, $nome!")
    
    print("Digite a nota 1: ")
    val nota_1 = readln().toInt()
    println("Nota 1: $nota_1")
    
    print("Digite a nota 2: ")
    val nota_2 = readln().toInt()
    println("Nota 2: $nota_2")
    
    val media =(nota_1 + nota_2) / 2
    if (media >= 5) {
        println ("O aluno "+nome+" foi aprovado com media " +media)
     }
     else {
        println("O aluno "+nome+" foi reprovado com media " +media)
     }
}

           
     