package Homework_11

/*
Задание 2:  Слияние двух отсортированных LinkedList в один (без Set, Map)
Даны два отсортированных LinkedList, нужно слить их в один
отсортированный список
*/

fun main() {
    val firstList = mutableListOf(1, 3, 5, 55)
    val secondList = mutableListOf(2, 4, 6, 7, 99)

    println("Первый лист: $firstList")
    println("Второй лист: $secondList")

    val resultList = mutableListOf<Int>()

    while (!(firstList.isEmpty() && secondList.isEmpty())) {

        if (firstList.isNotEmpty() && secondList.isNotEmpty()) {
            if (firstList.first() < secondList.first()) resultList.add(firstList.removeFirst())
            else resultList.add(secondList.removeFirst())
        }

        if (firstList.isEmpty() && secondList.isNotEmpty()) resultList.add(secondList.removeFirst())
        if (secondList.isEmpty() && firstList.isNotEmpty()) resultList.add(firstList.removeFirst())

    }

    println("Итоговый лист: $resultList")

}