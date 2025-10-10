package Homework_13


/*
Задание 3:
Создайте список чисел от 1 до 1,000,000, отфильтруйте четные числа,
затем возведите их в квадрат и посчитайте сумму всех этих чисел.
Сделайте это с использованием asSequence для ленивой обработки.*/

fun main(args: Array<String>) {
    val initialList = generateSequence(1) { if (it < 1000000) it + 1 else null }

    initialList.let {
        it.filter { it % 2 == 0 }
            .map { it * it.toLong() }
            .reduce { a, b -> a + b }
    }.apply { println("Сумма квадратов: $this") }

}
