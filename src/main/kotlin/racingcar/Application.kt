package racingcar

import racingcar.model.Car

fun main() {
    val car = Car("TestCar")
    car.carMove()
    println(car)
    car.carMove()
    println(car)
}
