package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Racing(private val cars: List<Car>) {
    fun race() {
        cars.forEach { car ->
            car.move(isMoveForward())
        }
    }

    private fun isMoveForward(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    fun getWinner(): List<Car> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }
    }

    fun getStatus(): List<String> {
        return cars.map { it.display() }
    }
}
