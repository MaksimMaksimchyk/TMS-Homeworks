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

    println("Программа проверяет, является ли число палиндромом.")
    println("Введите число:")
    val numberN = readln().toInt()


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

    println("Простое число. Программа проверяет, является ли число простым.")
    println("Введите число:")
    val number = readln().toInt()


    var isSimple = true
    var firstPrimeNumber = 0
    for (i in 2..number - 1) {
        if (number % i == 0) {
            isSimple = false
            firstPrimeNumber = i
            break
        }
    }

    if (isSimple == true) {
        println("Это простое число")
    } else println("Это не простое число, как минимум делится на $firstPrimeNumber")

}

//Задача 3: Вычисление суммы цифр числа до единичного разряда.
fun singleDigit() {

    println("Вычисление суммы цифр числа до единичного разряда.")
    println("Введите положительное целое число:")
    var number = readln().toInt()

    //Функция считает сумму цифр для введённого числа
    fun countSum(number: Int): Int {
        var sum = 0
        var bufNumber = number
        println()
        print("Сумма цифр числа $number =")
        var digit = 0
        var i = 1 //Итератор для количество цифр, чтобы для первой не печатался плюс
        while (bufNumber > 0) {
            digit = bufNumber % 10

            if (i == 1) {
                print(" $digit ")
            } else print("+ $digit ")

            sum += digit
            bufNumber /= 10
            i++
        }
        print(" = $sum")
        return sum
    }


    while (number / 10 > 0) {
        number = countSum(number)
    }

}


//Задача 4: Перевёрнутая лесенка.
fun invertedLadder() {
    println("Перевёрнутая лесенка.")
    println("Введите высоту лесенки:")
    val number = readln().toInt()

    for(i in number downTo 1){
        for (j in 1..i){
            print("#")
        }
        println()
    }
}
