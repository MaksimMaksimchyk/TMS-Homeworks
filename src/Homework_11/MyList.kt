package Homework_11

import Homework_7.Book

class MyList() {
    var firstElement: MyElementOfList? = null
    var lastElement: MyElementOfList? = null
    var countElements = 0

    fun add(addedValue: Int) {
        val newElement = MyElementOfList(addedValue, null)
        if (countElements == 0) {
            firstElement = newElement
            lastElement = newElement
            countElements++
        } else if (countElements == 1) {
            firstElement?.nextElement = newElement
            lastElement!!.nextElement = newElement
            lastElement = newElement
            countElements++
        } else {
            lastElement!!.nextElement = newElement
            lastElement = newElement
            countElements++
        }
    }

    fun printAllElements() {
        println("Всего элементов в списке: $countElements")
        var currentElement = firstElement
        print("Весь список: ")
        for (i in 1..countElements) {
            print(currentElement!!.elementValue)
            print(" ")
            currentElement = currentElement.nextElement
        }
    }

    fun remove(number: Int) {
        var currentElement = firstElement
        for (i in 1..countElements - 1) {
            if (currentElement?.nextElement?.elementValue == number) {
                currentElement.nextElement = currentElement.nextElement!!.nextElement
                countElements--
                return
            } else if (currentElement?.elementValue == number) {    //Проверка для первого элемента, без этого блока не хотел удаляться первый элемент
                firstElement = currentElement.nextElement
                countElements--
                return
            } else currentElement = currentElement?.nextElement
        }
    }

    fun findElement(num: Int): Int? {
        var currentElement = firstElement
        for (i in 1..countElements) {
            if (currentElement?.elementValue == num) {
                return i
            }
            currentElement = currentElement?.nextElement
        }
        return null
    }

    fun removeByIndex(index: Int) {
        if (index !in 1..countElements) {
            println("Неверный ввод индекса")
            return
        }
        var currentElement = firstElement
        for (i in 1..countElements) {
            if (i == index) {
                this.remove(currentElement!!.elementValue)
            }
            currentElement = currentElement?.nextElement
        }
    }

    fun findByIndex(index: Int): Int? {
        if (index !in 1..countElements) {
            println("Неверный ввод индекса")
            return null
        }
        var currentElement = firstElement
        for (i in 1..countElements) {
            if (i == index) {
                return currentElement!!.elementValue
            }
            currentElement = currentElement?.nextElement
        }
        return null
    }


    fun addByIndex(addedValue: Int, index: Int) {
        val newElement = MyElementOfList(addedValue, null)

        //Если в списке всего 0 или 0 элементов, то можно добавить в конец
        if (countElements == 0) {
            firstElement = newElement
            lastElement = newElement
            countElements++
        } else if (countElements == 1) {
            firstElement?.nextElement = newElement
            lastElement!!.nextElement = newElement
            lastElement = newElement
            countElements++
        }

        //Отдельный блок для вставки на первое место, иначе функция не работает
        if (index == 1) {
            newElement.nextElement = firstElement
            firstElement = newElement
            countElements++
            return
        }

        //Вставка в произвольое место
        var currentElement = firstElement
        for (i in 1..countElements - 1) {
            if (i == index - 1) {
                newElement.nextElement = currentElement?.nextElement
                currentElement?.nextElement = newElement
                countElements++
                return
            }
            currentElement = currentElement?.nextElement
        }

    }

}


class MyElementOfList(var elementValue: Int, var nextElement: MyElementOfList?) {

}