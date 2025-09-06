fun main() {
    //Выбор задачи
    var inputMenu: Int? = null
    do {
        println()
        println("Выберите задачу: ")
        println("1 -> Число палиндром. Программа проверяет, является ли число палиндромом.")
        println("2 -> Проверка простого числа. Программа проверяет, является ли число простым.")
        println("3 -> Вычисление суммы цифр числа до единичного разряда.")
        println("4 -> Перевёрнутая лесенка")
        println("Любая другая клавиша -> Выход")
        inputMenu = readLine()?.toIntOrNull()
        when (inputMenu) {
            1 -> palindrome()
            2 -> primeNumber()
            3 -> singleDigit()
            4 -> invertedLadder()
            else -> break

        }
    } while (inputMenu != null)

}

//Задача 1: Число палиндром. Программа проверяет, является ли число палиндромом.
fun palindrome() {

    //Ввод числа
    println("Программа проверяет, является ли число палиндромом.")
    var numberN: Int? = null
    while (numberN == null) {
        println("Введите число:")
        numberN = readLine()?.toIntOrNull()
        if (numberN == null) {
            println("Неверный ввод")
        }
    }

    // Переворачивание числа
    var reversedNumberN = 0
    var bufN = numberN
    var oneDigit = 0

    while (bufN > 0) {
        oneDigit = bufN % 10
        reversedNumberN = reversedNumberN * 10 + oneDigit
        bufN /= 10
    }

    if (reversedNumberN - numberN == 0) {
        println("Число $numberN являются палиндромом")
    } else println("Число $numberN не является палиндромом")

}

//Задача 2:Проверка простого числа. Программа проверяет, является ли число простым.
fun primeNumber() {
    println("Простое число. Программа проверяет, является ли число простым. Введите число:")
}

//Задача 3: Вычисление суммы цифр числа до единичного разряда.
fun singleDigit() {
    println("Вычисление суммы цифр числа до единичного разряда. Введите число:")
}

//Задача 4: Перевёрнутая лесенка.
fun invertedLadder() {
    println("Перевёрнутая лесенка. Введите высоту лесенки:")
}
