package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Stadium {
    fun race(cars: List<Car>, round: Int): List<List<Car>> {
        var raceResult: List<List<Car>> = emptyList()
        repeat(round) {
            cars.forEach(::move)
            val roundResult: List<Car> = cars
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