package racingcar.utils

import racingcar.data.Car

object Winner {
    fun calculate(cars: List<Car>) = winnerMapping(cars)

    private fun winnerMapping(cars: List<Car>) = cars.filter { it.distance == findMaxDistance(cars) }.map { it.name }

    private fun findMaxDistance(cars: List<Car>) = cars.maxBy { it.distance }.distance
}