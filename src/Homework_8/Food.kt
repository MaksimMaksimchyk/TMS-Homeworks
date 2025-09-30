package Homework_8

class Food(var name: String, var price: Double): Product {

    var discountPercent = 0

    override fun getFinalPrice() {
        println("К сожалению, на $name сейчас нет скидки. Цена составит $price$")
    }

}