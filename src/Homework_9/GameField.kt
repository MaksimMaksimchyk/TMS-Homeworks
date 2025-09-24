package Homework_9

import kotlin.random.Random

object GameField {

    var distance = 10
    var turnCounter = 0

    fun roll(): Int {
        return Random.nextInt(1, 7)
    }

    fun nextTurn(firstPlayer: Player, secondPlayer: Player) {
        turnCounter++
        if (turnCounter == 1) {
            println("Дуэль начинается...")
            showStatus(firstPlayer, secondPlayer)
        } else {
            println("Ход №$turnCounter")
            showStatus(firstPlayer, secondPlayer)
        }

        println("\n${firstPlayer.avatar} ${firstPlayer.name}, выберите действие: ")
        println("❶ - Атаковать ${MyEmojies.ATTACK.emoji}")
        println("❷ - Сдаться ${MyEmojies.SURRENDER.emoji}")
        val inputMenu = readlnOrNull()?.toIntOrNull()
        when (inputMenu) {
            1 -> {
                val rolled = roll()
                println("${firstPlayer.name} успешно атакует")
                secondPlayer.takeDamage(firstPlayer.attack(rolled))
                if (secondPlayer.hitPoints <= 0) {
                    congratWinner(firstPlayer)
                    return
                }
            }

            else -> {
                firstPlayer.giveUp()
                congratWinner(secondPlayer)
                return
            }
        }


        println("\n${secondPlayer.avatar} ${secondPlayer.name}, теперь ваша очередь: ")
        println("❶ - Атаковать ${MyEmojies.ATTACK.emoji}")
        println("❷ - Сдаться ${MyEmojies.SURRENDER.emoji}")
        val inputMenu2 = readlnOrNull()?.toIntOrNull()
        when (inputMenu2) {
            1 -> {
                val rolled = roll()
                println("${secondPlayer.name} успешно атакует")
                firstPlayer.takeDamage(secondPlayer.attack(rolled))
                if (firstPlayer.hitPoints <= 0) {
                    congratWinner(secondPlayer)
                    return
                }
            }

            else -> {
                secondPlayer.giveUp()
                congratWinner(firstPlayer)
                return
            }
        }
    }


    fun showStatus(firstPlayer: Player, secondPlayer: Player) {

        print(
            "${firstPlayer.name} ${MyEmojies.HITPOINTS.emoji}${firstPlayer.hitPoints} " +
                    "${MyEmojies.ARMORPOINTS.emoji}${firstPlayer.armorPoints}" +
                    " ${firstPlayer.avatar}"
        )
        for (i in 1..distance) {
            print("_")
        }
        print(
            "${secondPlayer.avatar} " +
                    "${MyEmojies.ARMORPOINTS.emoji}${secondPlayer.armorPoints}" +
                    "${MyEmojies.HITPOINTS.emoji}${secondPlayer.hitPoints} ${secondPlayer.name}\n"
        )
    }

    fun congratWinner(winner: Player) {
        println("${winner.name} победил! Ура!")
    }


}