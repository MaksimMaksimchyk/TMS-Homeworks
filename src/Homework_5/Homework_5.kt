fun main() {
    //Выбор задачи
    var inputMenu: Int? = null
    do {
        println()
        println("Выберите задачу: ")
        println("1 -> Перестановка слов в обратном порядке")
        println("2 -> Преобразование строки в ASCII-коды и обратно")
        println("Любая другая клавиша -> Выход")
        inputMenu = readLine()?.toIntOrNull()
        when (inputMenu) {
            1 -> reverseWordsInString()
            2 -> stringToCodes()
            else -> break
        }
    } while (inputMenu != null)


}


fun reverseWordsInString() {

}


fun stringToCodes() {

}
