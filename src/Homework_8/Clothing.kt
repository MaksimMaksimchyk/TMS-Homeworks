package Homework_8

class Clothing(var name: String, var price: Double): Product {

    var discountPercent = 15

    override fun getFinalPrice() {
        println("Цена \"$name\" с учётом скидки $discountPercent% составит ${price*(100-discountPercent)/100}$")
    }

}