package Homework_14

/*Задача 1: Синхронизация доступа к счетчику с помощью внешнего объекта
Вам нужно создать класс Counter, который будет иметь метод increment и метод
decrement. Эти методы должны увеличивать и уменьшать значение переменной
count в многопоточном режиме. Для синхронизации доступов используйте
внешний объект (не объект класса).*/

fun main(args: Array<String>) {

    val counter = Counter()

    val thread1 = Thread {
        for (i in 1..10000) {
            counter.increment()
        }
    }

    val thread2 = Thread {
        for (i in 1..10000) {
            counter.decrement()
        }
    }

    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()
    println(counter.count)
}

data class Person(val name: String, val age: Int) {
    override fun toString(): String {
        val result = "$name, $age"
        return result
    }

}

class Counter() {
    var count = 0
    val person = Person("", 0)
    fun increment() {
        synchronized(person) {
            count++
        }
    }

    fun decrement() {
        synchronized(person) {
            count--
        }
    }
}