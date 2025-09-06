import Homework_3.invertedLadder
import Homework_3.primeNumber
import Homework_3.singleDigit
import kotlin.random.Random

fun main() {
    //Выбор задачи
    var inputMenu: Int? = null
    do {
        println()
        println("Выберите задачу: ")
        println("1 -> Поиск максимального и минимального элемента массива")
        println("2 -> Подсчет четных и нечетных чисел в массиве")
        println("3 -> Реверс массива")
        println("4 -> Проверка массива на палиндром")
        println("Любая другая клавиша -> Выход")
        inputMenu = readLine()?.toIntOrNull()
        when (inputMenu) {
            1 -> maxAndMinElement()
            2 -> primeNumber()
            3 -> singleDigit()
            4 -> invertedLadder()
            else -> break

        }
    } while (inputMenu != null)

}

fun maxAndMinElement() {

    val arr = Array(10) { Random.nextInt(1, 100) }
    println("Сам массив с рандомыми числами: ")
    arr.forEach {
        println(it)
    }

    var minNumber = arr[0]
    var maxNumber = arr[0]
    var indexOfMinNumber = 0
    var indexOfMaxNumber = 0

    for (i in 0..arr.size - 1) {
        if (arr[i] < minNumber) {
            minNumber = arr[i]
            indexOfMinNumber = i
        }
        if (arr[i] > maxNumber) {
            maxNumber = arr[i]
            indexOfMaxNumber = i
        }
    }

    println("Минимальный элемент массива: $minNumber, с индексом $indexOfMinNumber")
    println("Максимальный элемент массива: $maxNumber, с индексом $indexOfMaxNumber")

}

