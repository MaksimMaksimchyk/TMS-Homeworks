package Homework_7
/*
1. Создать класс Book с полями title, author, year, первичным конструктором, методом toString().
2. Добавить метод equals() и hashCode() для сравнения книг по названию и автору.
3. Создать enum class Genre (FANTASY, DETECTIVE, SCIENCE, HISTORY).
4. Сделать абстрактный класс LibraryItem (с полем id) и наследовать от него Book.
5. Создать interface Borrowable с методом borrow(user: String) и реализовать его в Book.
6. И создать аналог Book через Data class и сравнить логику методов toString, equals, hashcode.
 */


fun main() {
    val myBook = Book("Funny Kotlin", "Maksim", 2025, 1)
    val myDataBook = DataBook("Funny Kotlin", "Maksim", 2025, 1)

    println("Класс Book, метод borrow:")
    myBook.borrow("Vladimir")
    println("Класс Book, метод toString:\n${myBook.toString()}")
    println("Класс DataBook, метод toString:\n${myDataBook.toString()}")
    println("Сравнение Book и DataBook: ${myBook.equals(myDataBook)}")
    println("И наоборот сравнение DataBook и Book: ${myDataBook.equals(myBook)}")
    println("Хэшкод Book: ${myBook.hashCode()}")
    println("Хэшкод DataBook: ${myDataBook.hashCode()}")

}