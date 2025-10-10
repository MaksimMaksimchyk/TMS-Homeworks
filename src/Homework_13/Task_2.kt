package Homework_13

import Homework_14.Person

/*
Задание 2: Применение атомарных типов для безопасного увеличения счетчика
Напишите программу, которая получает список людей, фильтрует только
тех, кто старше 18 лет, затем сортирует их по возрасту в порядке
убывания и выводит на экран с помощью apply и let. (sortedByDescending)*/

fun main() {
    val initialListOfPerson = listOf<Person>(
        Person(name = "Dora Hale", age = 25),
        Person(name = "Alfreda Clayton", age = 12),
        Person(name = "Tonia Mendez", age = 22),
        Person(name = "Yesenia Webster", age = 65),
        Person(name = "Parker Flynn", age = 89),
        Person(name = "Johnnie Clarke", age = 16),
        Person(name = "Edward Chang", age = 44),
        Person(name = "Irving Acosta", age = 45),
        Person(name = "Forest Hays", age = 33),
    )

    initialListOfPerson.let {
        println("Изначальный список: ")
        it.forEach { println(it.toString()) }
        it.filter { person -> person.age >= 18 }
            .sortedByDescending(Person::age)
    }.apply {
        println("Отсортированный список: ")
        this.forEach { println(it.toString()) }
    }

}

