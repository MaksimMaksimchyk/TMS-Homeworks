package Homework_10

fun main(args: Array<String>) {
    //Выбор задачи
    var inputMenu: Int? = null
    do {
        println()
        println("Выберите задачу: ")
        println("1 -> Деление с обработкой исключения")
        println("2 -> Проверка возраста (кастомное исключение)")
        println("3 -> Обработка пустой строки")
        println("Любая другая клавиша -> Выход")
        inputMenu = readlnOrNull()?.toIntOrNull()
        when (inputMenu) {
            1 -> division()
            2 -> inputAge()
            3 -> testEmptyString()
            else -> break
        }
    } while (inputMenu != null)

}

/*
Задача: Написать программу, которая делит два числа, введенных
пользователем.
Обработать:
⦁ ArithmeticException (деление на ноль)
⦁ InputMismatchException (если введено не число)
 */
fun division() {

    try {
        println("Введите первое число:")
        val firstNumber = readln().toInt()
        println("Введите второе число:")
        val secondNumber = readln().toInt()
        println("Результат: ${firstNumber / secondNumber}")
    } catch (e: NumberFormatException) {
        println("Вы ввели не число или не Int (NumberFormatException)")
        division()
    } catch (e: ArithmeticException) {
        println("На ноль делить нельзя")
        division()
    }
}


/*
Задача 2: Проверка возраста (кастомное исключение)
Задача: Попросить пользователя ввести возраст. Если возраст < 18,
выбросить исключение.
Используем кастомное исключение TooYoungException.
 */
fun inputAge() {
    var inputtedAge = 0

    try {
        println("Введите возраст:")
        inputtedAge = readln().toInt()
        if (inputtedAge < 18) throw TooYoungException()
        println("Возраст: $inputtedAge")
    } catch (e: NumberFormatException) {
        println("Вы ввели не число или не Int (NumberFormatException)")
        inputAge()
    } catch (e: TooYoungException) {
        println("Возраст меньше 18")
        inputAge()
    }

}


/*
Задача 3: Обработка пустой строки
Задача: Запросить у пользователя строку и проверить, что она не пустая.
Обработать:
⦁ IllegalArgumentException, если строка пустая
*/
fun testEmptyString() {

    try {
        println("Введите строку: ")
        val inputString = readln()
        if (inputString.isEmpty()) throw IllegalArgumentException()
        println("Ваша строка: $inputString")
    } catch (e: IllegalArgumentException) {
        println("Строка слишком пустая")
        testEmptyString()
    }

}