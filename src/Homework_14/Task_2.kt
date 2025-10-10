package Homework_14

import java.util.concurrent.atomic.AtomicInteger

/*Задача 2: Применение атомарных типов для безопасного увеличения счетчика
Напишите программу, в которой два потока одновременно увеличивают счетчик.
Вместо синхронизации используйте класс AtomicInteger, чтобы избежать
блокировок.*/

fun main() {
    var counter = AtomicInteger(0)

    val thread1 = Thread {
        for (i in 1..300) {
            println("Поток №1 увеличил счётчик на 1, счётчик = ${counter.get()}")
            counter.incrementAndGet()
        }
    }

    val thread2 = Thread {
        for (i in 1..300) {
            println("Поток №2 увеличил счётчик на 1, счётчик = ${counter.get()}")
            counter.incrementAndGet()
        }
    }

    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()
    println("Итоговое значение ${counter.get()}")

}