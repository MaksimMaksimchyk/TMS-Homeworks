package Homework_8

class Electronics(var name: String, var price: Double): Product {

    var discountPercent = 10

    override fun getFinalPrice() {
        println("Цена \"$name\" с учётом скидки $discountPercent% составит ${price*(100-discountPercent)/100}$")
    }

}