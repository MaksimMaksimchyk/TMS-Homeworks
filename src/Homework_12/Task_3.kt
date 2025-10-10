package Homework_12

/*
Задание 3: Поиск всех пар чисел, сумма которых равна заданному числу
Дан массив чисел и целевое значение target. Нужно найти все пары
чисел, сумма которых равна target.
*/

fun main(args: Array<String>) {
    val arrayNumbers = arrayOf<Int>(1, 2, 5, 3, 4, 7, 12, 34, 8, -4, 0)
    println("Массив чисел: ")
    arrayNumbers.forEach { print("$it ") }
    println("\nВведите target (нужно найти все пары чисел, сумма которых равна target): ")
    val target = readln().toInt()

    var targetIsFinded = false
    for (i in 0..arrayNumbers.size - 1) {
        for (j in i..arrayNumbers.size - 2) {
            if (arrayNumbers[i] + arrayNumbers[j + 1] == target) {
                println("Пара чисел, сумма которых равна $target: ${arrayNumbers[i]} и ${arrayNumbers[j + 1]}")
                targetIsFinded = true
            }
        }
    }
    if (targetIsFinded == false) println("Пары чисел для $target не найдены")

}