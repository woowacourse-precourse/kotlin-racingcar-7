package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>, private val attempts: Int) {
    fun startRace(): List<List<Car>> {
        return List(attempts) {
            moveCars()
            cars.map { it.copy() }
        }
    }

    private fun moveCars() {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            car.move(randomNumber)
        }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}