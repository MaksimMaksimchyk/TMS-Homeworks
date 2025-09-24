package Homework_9

fun main() {
    println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔ДОБРО ПОЖАЛОВАТЬ В ДУЭЛЬ!⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔")
    println("Игроки сражаются, по очереди бросая кубик. Проигрывает тот, у кого первым закончится здоровье (или терпение).")
    val firstPlayer = Player()
    val secondPlayer = Player()

    //Выбор классов и имени
    println("\nИгрок №1, как Вас зовут?")
    firstPlayer.name = readLine().toString()
    firstPlayer.chooseGamingClas()

    println("\nИгрок №2, теперь Ваша очередь. Как Вас зовут?")
    secondPlayer.name = readLine().toString()
    secondPlayer.chooseGamingClas()

    //Игроки ходят, пока у одного из них не закончится здоровье
    while (firstPlayer.hitPoints > 0 && secondPlayer.hitPoints > 0) {
        GameField.nextTurn(firstPlayer, secondPlayer)
    }


}