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
        inputMenu = readlnOrNull()?.toIntOrNull()
        when (inputMenu) {
            1 -> maxAndMinElement()
            2 -> countOddAndEven()
            3 -> reverseArray()
            4 -> checkForPal()
            else -> break
        }
    } while (inputMenu != null)

}

fun maxAndMinElement() {

    val arr = Array(5) { Random.nextInt(1, 100) }
    println("Сам массив из ${arr.size} элементов с рандомыми числами: ")
    arr.forEach {
        print("$it ")
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

    println()
    println("Минимальный элемент массива: $minNumber, с индексом $indexOfMinNumber")
    println("Максимальный элемент массива: $maxNumber, с индексом $indexOfMaxNumber")

}

fun countOddAndEven() {

    val arr = Array(5) { Random.nextInt(1, 100) }
    println("Сам массив из ${arr.size} элементов с рандомыми числами: ")
    arr.forEach {
        print("$it ")
    }

    var countEven = 0
    var countOdd = 0

    for (i in 0..arr.size - 1) {
        if (arr[i] % 2 == 0) countEven++
        else countOdd++
    }

    println()
    println("Количество чётных: $countEven")
    println("Количество нечётных: $countOdd")

}

fun reverseArray() {

    val arr = Array(5) { Random.nextInt(1, 100) }
    println("Изначальный массив из ${arr.size} элементов с рандомыми числами: ")
    arr.forEach {
        print("$it ")
    }

    val reversedArr = Array(arr.size) { 0 }
    for (i in 0..arr.size - 1) {
        reversedArr[i] = arr[arr.size - 1 - i]
    }

    println()
    println("Перевернутый массив: ")
    reversedArr.forEach {
        print("$it ")
    }
}

fun checkForPal() {

    val arr = arrayOf(1, 1, 60, 61, 1)
    println("Изначальный массив: ")
    arr.forEach {
        print("$it ")
    }

    val reversedArr = Array(arr.size) { 0 }
    for (i in 0..arr.size - 1) {
        reversedArr[i] = arr[arr.size - 1 - i]
    }

    println()
    println("Перевернутый массив: ")
    reversedArr.forEach {
        print("$it ")
    }

    var isPal = true
    for (i in 0..arr.size - 1) {
        if (arr[i] != reversedArr[i]) isPal = false
    }

    println()
    if (isPal == true) println("Массив является палиндромом")
    else println("Массив не является палиндромом")

}


