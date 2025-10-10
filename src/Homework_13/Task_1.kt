package Homework_13

/*Задача 1:
Напишите функцию, которая принимает список целых чисел и
возвращает их сумму. Используйте лямбду в качестве параметра для
определения операции. (Reduce)*/

fun main(args: Array<String>) {
    val listOfNumbers = listOf<Int>(1, 2, 3, 4)
    println("Список чисел: $listOfNumbers")

    val sumResult = operationOfNumbers(listOfNumbers) { acc, i -> acc + i }
    println("Сумма всех чисел: $sumResult")

    val testSumResult = operationOfNumbers(listOfNumbers) { acc, i ->
        if (i != 4) acc + i else acc + 0
    }
    println("Сумма всех чисел за исключением 4 (тест): $testSumResult")


}


fun operationOfNumbers(list: List<Int>, testLambda: (acc: Int, i: Int) -> Int): Int {
    return list.reduce(testLambda)
}
