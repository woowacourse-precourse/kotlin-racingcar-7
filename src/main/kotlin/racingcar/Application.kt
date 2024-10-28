package racingcar

import racingcar.model.Car
import racingcar.model.CarMove
import racingcar.model.RandomGenerator

fun main() {
    val car = Car("TestCar", CarMove(RandomGenerator()))
    repeat(5) {
        car.move()
        println(car)
    }
}
