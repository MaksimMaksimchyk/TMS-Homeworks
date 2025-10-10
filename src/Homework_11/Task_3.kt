package Homework_11

/*
Задание 3: Однонаправленный список
Напишите реализацию однонаправленного списка без использования
Collection и массивов. Должны быть методы добавления, удаления и
поиска элементов.
Реализовать все операции по индексу
*/

fun main(args: Array<String>) {
    //Класс MyList реализует список, но только для типа Int. Индекс начинается с 1.
    val testList = MyList()
    testList.add(15)
    testList.add(22)
    testList.add(33)
    testList.add(44)
    testList.add(55)

    testList.printAllElements()

    //Выбор действия
    var inputMenu: Int? = null
    do {
        println()
        println("Действия со списком: ")
        println("1 -> Добавить число в конец")
        println("2 -> Удалить число")
        println("3 -> Найти число")
        println("4 -> Удалить число по номеру")
        println("5 -> Получить число по номеру")
        println("6 -> Добавить число на конкретную позицию")
        println("Любая другая клавиша -> Выход")
        inputMenu = readlnOrNull()?.toIntOrNull()
        when (inputMenu) {
            1 -> {
                println("Какое число добавить в конец списка?")
                val number = readln().toInt()
                testList.add(number)
                println("Число $number добавлено")
                testList.printAllElements()
            }

            2 -> {
                println("Какое число удалить?")
                val number = readln().toInt()
                if (testList.findElement(number) != null) {
                    testList.remove(number)
                    println("Число $number удалено")
                } else println("Такого числа нет в списке")
                testList.printAllElements()
            }

            3 -> {
                println("Какое число найти?")
                val number = readln().toInt()
                if (testList.findElement(number) != null) {
                    println("Число $number есть в списке, порядковый номер ${testList.findElement(number)}")
                } else println("Элемента нет в списке")
            }

            4 -> {
                println("Введите порядковый номер элемента для удаления")
                val number = readln().toInt()
                testList.removeByIndex(number)
                println("Удалён элемент № $number")
                testList.printAllElements()
            }

            5 -> {
                println("Введите порядковый номер элемента")
                val number = readln().toInt()
                if (testList.findByIndex(number) != null) {
                    println("Искомый элемент: ${testList.findByIndex(number)}")
                }
            }

            6 -> {
                println("Введите число:")
                val number = readln().toInt()
                println("На какое место добавить элемент?")
                val index = readln().toInt()
                if (index !in 0..testList.countElements) {
                    println("Неверный ввод")
                } else {
                    testList.addByIndex(number, index)
                    testList.printAllElements()
                }
            }

            else -> break
        }
    } while (inputMenu != null)


}