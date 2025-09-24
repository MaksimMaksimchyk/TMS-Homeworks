package Homework_9

class Player() {
    var name = "New Player"
    var attackPoints = 0
    var armorPoints = 0
    var hitPoints = 0
    var damageReducePoints = 0
    var avatar = ""
    var gamingClas = GamingClasses.NOOB

    fun chooseGamingClas() {
        println("${this.name}, выберите класс:")
        var inputMenu: Int? = null
        do {
            println("❶ - Паладин ${MyEmojies.PALADIN.emoji}. Много здоровья, слабая атака, тяжелая броня. Силён в ближнем бою.")
            println("❷ - Лучник ${MyEmojies.ARCHER.emoji}. Очень сильная атака, мало здоровья, легкая броня. Силён в дальнем бою.")
            println("❸ - Разбойник ${MyEmojies.ROGUE.emoji}. Сильная атака, среднее количество здоровья, средняя броня. Универсальный боец.")
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
                this.hitPoints = 30
                this.damageReducePoints = 3
                this.avatar = MyEmojies.PALADIN.emoji
                this.gamingClas = GamingClasses.PALADIN
                println("Отличный выбор, ${this.name}! Теперь Вы Паладин!")
            }

            GamingClasses.ARCHER -> {
                this.attackPoints = 3
                this.armorPoints = 3
                this.hitPoints = 12
                this.damageReducePoints = 1
                this.avatar = MyEmojies.ARCHER.emoji
                this.gamingClas = GamingClasses.ARCHER
                println("Отличный выбор, ${this.name}! Теперь Вы Лучник!")
            }

            GamingClasses.ROGUE -> {
                this.attackPoints = 2
                this.armorPoints = 6
                this.hitPoints = 21
                this.damageReducePoints = 2
                this.avatar = MyEmojies.ROGUE.emoji
                this.gamingClas = GamingClasses.ROGUE
                println("Отличный выбор, ${this.name}! Теперь Вы Разбойник!")
            }

            else -> println("Какая-то ошибка с выбором класса")

        }

    }


    fun attack(rolled: Int): Int {
        return rolled * this.attackPoints
    }

    fun takeDamage(damage: Int) {
        if (this.armorPoints > 0) {
            this.armorPoints -= 1
            println("${this.name} теряет 1 ед. брони${MyEmojies.ARMORPOINTS.emoji}")
        } else{
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
        GameField.distance++
    }

    fun moveForward() {
        GameField.distance--
    }

    fun giveUp() {
        this.hitPoints = 0
    }


}