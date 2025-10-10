package Homework_12

/*
Задание 2:  Поиск первого повторяющегося числа
Дан список чисел, нужно найти первое число, которое повторяется.
*/

fun main(args: Array<String>) {
    val listOfNumbers = listOf<Int>(1, 2, 2, 3, 4, 5, 12, 34)
    println("Список чисел: $listOfNumbers")

    val arrayNumbers = listOfNumbers.toIntArray()

    var firstRepeatedNumber: Int? = null
    for (i in 0..arrayNumbers.size - 1) {
        for (j in i..arrayNumbers.size - 2) {
            if (arrayNumbers[i] == arrayNumbers[j + 1]) {
                firstRepeatedNumber = arrayNumbers[i]
                break
            }
        }
        if (firstRepeatedNumber != null) {
            break
        }
    }

    if (firstRepeatedNumber != null) {
        println("Первое повторяющиеся число: $firstRepeatedNumber")
    } else println("В списке нет повторяющихся чисел")

}