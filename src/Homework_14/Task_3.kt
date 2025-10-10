package Homework_14

/*
Синхронизация потоков для предотвращения гонки данных
Напишите программу с двумя потоками, которые одновременно увеличивают
и уменьшают значение счетчика. Ваша задача — обеспечить, чтобы операция
увеличения и уменьшения была выполнена безопасно с помощью
синхронизации.*/

fun main() {
    val testCounter = SyncCounter()

    val thread1 = Thread {
        for (i in 1..3000) {
            testCounter.increment()
        }
    }
    val thread2 = Thread {
        for (i in 1..3000) {
            testCounter.decrement()
        }
    }
    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()
    println("Итоговый счётчик: ${testCounter.count} (должно быть 0)")

}


class SyncCounter() {
    var count = 0

    @Synchronized
    fun increment() {
        count++
    }

    @Synchronized
    fun decrement() {
        count--
    }
}



