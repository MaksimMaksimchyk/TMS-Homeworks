package Homework_11

import java.util.LinkedList

/*
Задание 1: Последний оставшийся элемент (LinkedList)
В круге из n человек каждый 2-й выбывает, пока не останется один.
Используйте LinkedList для моделирования
*/

fun main() {
    val listOfPeoples = LinkedList<String>()

    //Добавление людей в лист
    listOfPeoples.add("Maksim")
    listOfPeoples.add("Bob")
    listOfPeoples.add("Kate")
    listOfPeoples.add("Sergey")
    listOfPeoples.add("John")
    listOfPeoples.add("Petya")
    listOfPeoples.add("Sasha")

    println("Изначальный круг: $listOfPeoples")

    var currentIndex = 0

    while (listOfPeoples.size > 1) {
        currentIndex = (currentIndex + 1) % listOfPeoples.size
        val removed = listOfPeoples.removeAt(currentIndex)
        println("Вторым оказывается $removed, в кругу остаются: $listOfPeoples")
    }
    if (currentIndex == listOfPeoples.size) {
        currentIndex = 0
    }

    println("Победитель: $listOfPeoples")


}




