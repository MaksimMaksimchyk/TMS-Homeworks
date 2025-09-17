fun main() {
    //Выбор задачи
    var inputMenu: Int? = null
    do {
        println()
        println("Выберите задачу: ")
        println("1 -> Перестановка слов в обратном порядке")
        println("2 -> Преобразование строки в ASCII-коды и обратно")
        println("Любая другая клавиша -> Выход")
        inputMenu = readlnOrNull()?.toIntOrNull()
        when (inputMenu) {
            1 -> reverseWordsInString()
            2 -> stringToCodes()
            else -> break
        }
    } while (inputMenu != null)

}


//Перестановка слов в обратном порядке
fun reverseWordsInString() {

    println("\nИзначальная строка: ")
    val originalStr = "Hello World i am Kotlin"
    println(originalStr)

    val reversedStr = originalStr.split(' ').reversed().joinToString(" ")
    println(reversedStr) //проверка

}


//Преобразование строки в ASCII-коды и обратно
fun stringToCodes() {

    println("\nИзначальная строка: ")
    val originalStr = "Hello World i am Kotlin"
    println(originalStr)

    println("Преобразование строки в коды: ")
    val strBuilderCodes = StringBuilder()
    for (char in originalStr) {
        strBuilderCodes.append(char.code)
        strBuilderCodes.append(",")
    }

    val strOfCodes = strBuilderCodes.toString().dropLast(1) //чтобы удалить лишнюю запятую после последнего элемента
    println(strOfCodes)

    println("Теперь наоборот преобразование кодов в строку: ")
    val strBuilderLetters = strOfCodes.split(",")
    for (char in strBuilderLetters) {
        print(char.toInt().toChar())
    }
    println()

}
