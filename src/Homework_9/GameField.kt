package Homework_9

import kotlin.random.Random

object GameField {

    var distance = 10
    var turnCounter = 0


    fun showStatus(firstPlayer: Player, secondPlayer: Player) {
        print(
            "\n${firstPlayer.name} ${MyEmojies.HITPOINTS.emoji}${firstPlayer.hitPoints} " +
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


    fun roll(): Int {
        return Random.nextInt(1, 7)
    }


    fun showCube(rolled: Int, roller: Player) {
        print("\n${roller.name} бросает кубик: ")
        when (rolled) {
            1 -> print(MyEmojies.CUBEONE.emoji)
            2 -> print(MyEmojies.CUBETWO.emoji)
            3 -> print(MyEmojies.CUBETHREE.emoji)
            4 -> print(MyEmojies.CUBEFOUR.emoji)
            5 -> print(MyEmojies.CUBEFIVE.emoji)
            6 -> print(MyEmojies.CUBESIX.emoji)
        }
        print("\n")
    }


    fun congratsWinner(winner: Player) {
        println("${winner.name} победил(-а)! Ура!")
    }


    fun nextTurn(firstPlayer: Player, secondPlayer: Player) {
        turnCounter++
        println()
        if (turnCounter == 1) {
            println("Дуэль начинается...")
            showStatus(firstPlayer, secondPlayer)
        } else {
            println("Ход №$turnCounter")
            showStatus(firstPlayer, secondPlayer)
        }

        println("\n${firstPlayer.avatar} ${firstPlayer.name}, ваш ход.")
        chooseAction(firstPlayer, secondPlayer)

        showStatus(firstPlayer, secondPlayer)

        if (firstPlayer.hitPoints > 0 && secondPlayer.hitPoints > 0) {
            println("\n${secondPlayer.avatar} ${secondPlayer.name}, теперь ваша очередь. ")
            chooseAction(secondPlayer, firstPlayer)
        }

    }


    fun chooseAction(activePlayer: Player, passivePlayer: Player) {
        var actionPoints = 3
        while (actionPoints > 0) {
            println("Осталось $actionPoints ${MyEmojies.ACTIONPOINTS.emoji}. Выберите действие:")
            println("❶ - Атаковать ${MyEmojies.ATTACK.emoji} (2 ед. ${MyEmojies.ACTIONPOINTS.emoji})")
            println("❷ - Подойти ближе ${MyEmojies.MOVEFORWARD.emoji} (1 ед.${MyEmojies.ACTIONPOINTS.emoji})")
            println("❸ - Отойти подальше ${MyEmojies.MOVEBACK.emoji} (1 ед.${MyEmojies.ACTIONPOINTS.emoji})")
            println("❹ - ${activePlayer.specialAbilityDescription} (3 ед.${MyEmojies.ACTIONPOINTS.emoji})")
            println("Else - Сдаться ${MyEmojies.SURRENDER.emoji}")
            val inputMenu = readlnOrNull()?.toIntOrNull()
            when (inputMenu) {
                1 -> {
                    if (actionPoints >= 2) {
                        actionPoints -= 2
                        val rolled = roll()
                        showCube(rolled, activePlayer)
                        println("${activePlayer.name} успешно атакует")
                        passivePlayer.takeDamage(activePlayer.calulateAttack(rolled))
                        if (passivePlayer.hitPoints <= 0) {
                            congratsWinner(activePlayer)
                            return
                        }
                    } else {
                        println("Недостаточно ${MyEmojies.ACTIONPOINTS.emoji}")
                    }

                }

                2 -> {
                    actionPoints -= 1
                    activePlayer.moveForward()
                }

                3 -> {
                    actionPoints -= 1
                    activePlayer.moveBack()
                }

                4 -> {
                    if (actionPoints == 3) {
                        actionPoints -= 3
                        activePlayer.useSpecialAbility(activePlayer, passivePlayer)
                        if (passivePlayer.hitPoints <= 0) {
                            congratsWinner(activePlayer)
                            return
                        }
                    } else {
                        println("Недостаточно ${MyEmojies.ACTIONPOINTS.emoji}")
                    }

                }

                else -> {
                    activePlayer.giveUp()
                    congratsWinner(passivePlayer)
                    return
                }
            }
        }


    }


}