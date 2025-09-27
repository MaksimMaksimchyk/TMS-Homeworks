package Homework_9

import kotlin.random.Random

class Player() {
    var name = "New Player"
    var attackPoints = 0
    var armorPoints = 0
    var hitPoints = 0
    var damageReducePoints = 0
    var avatar = ""
    var specialAbilityDescription = ""
    var gamingClas = GamingClasses.NOOB

    fun chooseGamingClas() {
        println("${this.name}, выберите класс:")
        var inputMenu: Int? = null
        do {
            println("❶ - Паладин ${MyEmojies.PALADIN.emoji}. Много здоровья, слабая атака, тяжелая броня. Силён в ближнем бою. Может восстанавливать здоровье.")
            println("❷ - Лучник ${MyEmojies.ARCHER.emoji}. Очень сильная атака, мало здоровья, легкая броня. Силён в дальнем бою. Может убить с одного выстрела.")
            println("❸ - Разбойник ${MyEmojies.ROGUE.emoji}. Сильная атака, среднее количество здоровья, средняя броня. Универсальный боец. Может красть здоровье у противника")
            inputMenu = readlnOrNull()?.toIntOrNull()
            when (inputMenu) {
                1 -> this.setAttributes(chosenGamingClas = GamingClasses.PALADIN)
                2 -> this.setAttributes(chosenGamingClas = GamingClasses.ARCHER)
                3 -> this.setAttributes(chosenGamingClas = GamingClasses.ROGUE)
                else -> println("Неверный ввод, попробуйте ещё раз")
            }

        } while (this.gamingClas == GamingClasses.NOOB)
    }


    fun setAttributes(chosenGamingClas: GamingClasses) {
        when (chosenGamingClas) {

            GamingClasses.PALADIN -> {
                this.attackPoints = 1
                this.armorPoints = 10
                this.hitPoints = 60
                this.damageReducePoints = 3
                this.avatar = MyEmojies.PALADIN.emoji
                this.gamingClas = GamingClasses.PALADIN
                this.specialAbilityDescription = "Восстановить 15 ед. здоровья"
                println("Отличный выбор, ${this.name}! Теперь Вы Паладин!")
            }

            GamingClasses.ARCHER -> {
                this.attackPoints = 3
                this.armorPoints = 3
                this.hitPoints = 15
                this.damageReducePoints = 1
                this.avatar = MyEmojies.ARCHER.emoji
                this.gamingClas = GamingClasses.ARCHER
                this.specialAbilityDescription = "Выстрелить, целясь в голову. С вероятностью 10% наносит смертельный урон. "
                println("Отличный выбор, ${this.name}! Теперь Вы Лучник!")
            }

            GamingClasses.ROGUE -> {
                this.attackPoints = 2
                this.armorPoints = 6
                this.hitPoints = 25
                this.damageReducePoints = 2
                this.avatar = MyEmojies.ROGUE.emoji
                this.gamingClas = GamingClasses.ROGUE
                this.specialAbilityDescription = "Украсть 5 ед. здоровья у противника"
                println("Отличный выбор, ${this.name}! Теперь Вы Разбойник!")
            }

            else -> println("Какая-то ошибка с выбором класса")

        }

    }


    fun calulateAttack(rolled: Int): Int {
        var distanceFactor = 0
        if (this.gamingClas == GamingClasses.PALADIN) {
            when (GameField.distance) {
                10 -> 0
                in 4..9 -> distanceFactor = 4
                in 0..3 -> distanceFactor = 6
                in 11..99 -> distanceFactor = -1
            }
        }

        if (this.gamingClas == GamingClasses.ARCHER) {
            when (GameField.distance) {
                10 -> 0
                in 4..9 -> distanceFactor = -1
                in 0..3 -> distanceFactor = -1
                in 11..19 -> distanceFactor = 4
                in 20..99 -> distanceFactor = 6
            }
        }

        return rolled * this.attackPoints + distanceFactor
    }

    fun takeDamage(damage: Int) {
        if (this.armorPoints > 0) {
            this.armorPoints -= 1
            println("${this.name} теряет 1 ед. брони${MyEmojies.ARMORPOINTS.emoji}")
        } else {
            this.damageReducePoints = 0
            println("${this.name} теряет свою броню${MyEmojies.ARMORPOINTS.emoji}")
        }
        if (damage > this.damageReducePoints) {
            val takenDamage = damage - this.damageReducePoints
            this.hitPoints -= takenDamage
            println("${this.name} получает $takenDamage ед. урона${MyEmojies.DAMAGE.emoji}")
        }
    }

    fun moveBack() {
        println("${this.name}${this.avatar} убегает")
        GameField.distance += 2
    }


    fun moveForward() {
        if (GameField.distance > 1) {
            println("${this.name}${this.avatar} подходит ближе")
            GameField.distance -= 2
        } else {
            println("${this.name}${this.avatar} Попытался подойти, но вы и так стоите вплотную")
        }

    }

    fun giveUp() {
        this.hitPoints = 0
    }


    fun useSpecialAbility(activePlayer: Player, passivePlayer: Player) {
        when (this.gamingClas) {
            GamingClasses.PALADIN -> {
                println("${activePlayer.avatar}${activePlayer.name} восстанавливает 15 ${MyEmojies.HITPOINTS.emoji}")
                activePlayer.hitPoints += 15
            }

            GamingClasses.ARCHER -> {
                val roll = Random.nextInt(1, 11)
                if (roll == 1) {
                    println("${activePlayer.avatar}${activePlayer.name} Попадает в голову!")
                    passivePlayer.hitPoints = 0
                } else {
                    println("${activePlayer.avatar}${activePlayer.name} промахивается")
                }
            }
            GamingClasses.ROGUE -> {
                println("${activePlayer.avatar}${activePlayer.name} восстанавливает 5 ${MyEmojies.HITPOINTS.emoji}, а ${passivePlayer.avatar}${passivePlayer.name} теряет 5 ${MyEmojies.HITPOINTS.emoji}")
                activePlayer.hitPoints += 5
                passivePlayer.hitPoints -= 5
            }
            else -> {
                println("Вы ещё нуб")
            }
        }
    }


}