package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Stadium
import racingcar.util.isValidCarName
import racingcar.util.parseCarNames

class ViewModel(private val stadium: Stadium = Stadium()) {
    private var cars: List<Car> = emptyList()

    val winners: List<String>
        get() {
            val maxMovedDistance = cars.maxOf { car -> car.movedDistance }
            return cars.filter { car -> car.movedDistance == maxMovedDistance }.map { car -> car.name }
        }

    private var round: Int? = null

    fun updateCarNames(input: String) {
        val newCarNames = parseCarNames(input)
        if (newCarNames.any { carName -> !carName.isValidCarName }) throw IllegalArgumentException()
        cars = newCarNames.map { carName -> Car(carName) }
    }

    fun updateRound(input: Int) {
        if (input <= 0) throw IllegalArgumentException()
        this.round = input
    }

    fun race(): List<List<String>> = stadium.race(cars, round ?: throw IllegalArgumentException())
}