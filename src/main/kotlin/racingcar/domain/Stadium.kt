package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Stadium {
    fun race(cars: List<Car>, round: Int): List<List<String>> {
        var raceResult: List<List<String>> = emptyList()
        repeat(round) {
            cars.forEach(::move)
            val roundResult: List<String> = cars.map { car -> "${car.name} : ${"-".repeat(car.movedDistance)}" }
            raceResult = raceResult.plusElement(roundResult)
        }
        return raceResult
    }

    private fun move(car: Car) {
        if (isMovable) car.moveForward()
    }

    private val isMovable: Boolean
        get() = Randoms.pickNumberInRange(0, 9) >= 4
}