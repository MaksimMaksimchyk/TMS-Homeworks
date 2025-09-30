package Homework_8

/*
Задание в ДЗ:
Создай систему товаров для интернет-магазина. Каждый товар должен
уметь вычислять свою цену с учетом скидки.
• Интерфейс Product с методом double getFinalPrice()
• Классы Electronics, Clothing и Food**, которые реализуют этот
интерфейс
    • Electronics (например, смартфон) имеет скидку 10%
    • Clothing (например, куртка) имеет скидку 15%
    • Food (например, хлеб) **не имеет скидки
• В main() добавь товары в список и выведи их финальные цены
 */

fun main() {
    val listOfProdcts = listOf<Product>(
        Electronics("Apple 17 Pro", 700.0),
        Electronics("Smart TV", 500.0),
        Clothing("Куртка", 25.0),
        Food("Хлеб", 5.0),
    )

    listOfProdcts.forEach {it.getFinalPrice()}

}
