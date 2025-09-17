package Homework_6

fun main() {
    //Выбор задачи
    var inputMenu: Int? = null
    do {
        println()
        println("\nВыберите задачу: ")
        println("1 -> Сортировка массива с отрицательными числами")
        println("2 -> Частотная сортировка (сортирует массив по частоте появления элементов)")
        println("3 -> Минимальное количество перестановок для сортировки")
        println("Любая другая клавиша -> Выход")
        inputMenu = readlnOrNull()?.toIntOrNull()
        when (inputMenu) {
            1 -> sortNegative()
            2 -> sortFrequncy()
            3 -> sortTranspositions()
            else -> break
        }
    } while (inputMenu != null)

}


/*
Задание 1: Сортировка массива с отрицательными числами
Отсортируйте массив, чтобы отрицательные числа находились перед положительными, сохраняя порядок внутри каждой группы.
Пример:
Вход: [4, -3, 2, -1, 0, -5]
Выход: [-3, -1, -5, 4, 2, 0]
 */
fun sortNegative() {
    val numbers = arrayOf(4, -3, 2, -1, 0, -5)
    var countPositive = 0
    var countNegative = 0
    var countNulls = 0

    println("\nИзначальный массив: ")
    numbers.forEach {
        print("$it ")
        when {
            (it > 0) -> countPositive++
            (it < 0) -> countNegative++
            (it == 0) -> countNulls++
        }
    }

    //Разбиение массива на 3 части
    val positiveArray = Array(countPositive) { 0 }
    val negativeArray = Array(countNegative) { 0 }
    val nullsArray = Array(countNulls) { 0 }
    var positiveIterator = 0
    var negativeIterator = 0
    var nullIterator = 0
    numbers.forEachIndexed { index, number ->
        when {
            (number > 0) -> {
                positiveArray[positiveIterator] = number
                positiveIterator++
            }

            (number < 0) -> {
                negativeArray[negativeIterator] = number
                negativeIterator++
            }

            (number == 0) -> {
                nullsArray[nullIterator] = number
                nullIterator++
            }
        }
    }

    //Соедиение 3-х массивов в один:
    val sortedNumbers = negativeArray + positiveArray + nullsArray

    println("\nОтсортированный массив: ")
    sortedNumbers.forEach {
        print("$it ")
    }


}

/*
Задание 2: Частотная сортировка
Напишите функцию, которая сортирует массив по частоте появления элементов (по убыванию).
Если два элемента встречаются одинаковое количество раз, сортируйте их по возрастанию.
Пример:
Вход: [4, 5, 6, 5, 4, 3]
Выход: [4, 4, 5, 5, 6, 3]
 */
fun sortFrequncy() {
    val numbers = arrayOf(4, 5, 6, 5, 4, 3)

    println("\nИзначальный массив: ")
    numbers.forEach {
        print("$it ")
    }

    //Частота появления элементов
    val freqMap = numbers.groupingBy { it }.eachCount()

    //Сортировка по частоте появления и затем по возрастанию
    val sortedNumbers = numbers.sortedWith(
        compareByDescending<Int> { freqMap.getOrDefault(it, 0) }
            .thenBy { it }
    )

    println("\nПо частоте появления и возрастанию: ")
    sortedNumbers.forEach {
        print("$it ")
    }

}

/*
Задание 3: Минимальное количество перестановок для сортировки
Напишите функцию, которая возвращает минимальное количество перестановок, необходимых для сортировки массива.
Пример:
Вход: [4, 3, 2, 1]
Выход: 2 (перестановки [4, 1] и [3, 2])
 */
fun sortTranspositions() {
    val numbers = arrayOf(4, 3, 2, 1)

    println("\nИзначальный массив: ")
    numbers.forEach {
        print("$it ")
    }

    //Предполагаем, что метод sort() очень умный, поэтому использует минимальное количество перестановок
    val sortedNumbers = numbers.clone()
    sortedNumbers.sort()

    //Затем необходимо сравнить изначальный массив и отсортированный

    //Количество перестановок
    var countTranspositions = 0

    //Мапа, которая будет показывать, участвовало ли число в перестановке
    val map = numbers.associateWith { false }.toMutableMap()

    //Формирование строки с ответом
    val buildAnswer = StringBuilder()

    for (i in 0..numbers.size - 1) {
        if (numbers[i] != sortedNumbers[i] && map[numbers[i]] == false && map[sortedNumbers[i]] == false) {
            buildAnswer.append("[${numbers[i]}, ${sortedNumbers[i]}] и ")
            map.set(sortedNumbers[i], true)
            countTranspositions++
          }
    }

    buildAnswer.insert(0, "\nКоличество перестановок: $countTranspositions (")
    buildAnswer.delete(buildAnswer.length - 3, buildAnswer.length)
    buildAnswer.append(")")

    println("\nОтсортированный массив: ")
    sortedNumbers.forEach {
        print("$it ")
    }

    println(buildAnswer.toString())

}