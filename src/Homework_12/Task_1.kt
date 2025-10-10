package Homework_12

/*
Задание 1: Группировка анаграмм
Дан список слов. Нужно сгруппировать слова, которые являются
анаграммами.
{"listen", "silent", "enlist", "java", "avaj", "world"}
*/

fun main(args: Array<String>) {
    val list = listOf<String>("listen", "silent", "enlist", "java", "avaj", "world")
    println("Список слов: $list")
    val mutableMap = mutableMapOf<String, MutableList<String>>() //Ключ - отсортированное слово, значение - само слово

    for (word in list) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
        mutableMap.getOrPut(sortedWord) { mutableListOf() }.add(word)


    }

    var iterator = 1
    mutableMap.forEach { key, value ->
        println("Группа анаграмм №$iterator: $value")
        iterator++
    }

}

/*
fun isAnagram(str1: String, str2: String): Boolean {

    if (str1.length != str2.length) return false
    val sortedstr1 = str1.toCharArray().sorted()
    val sortedstr2 = str2.toCharArray().sorted()
    return sortedstr1 == sortedstr2

}
*/
