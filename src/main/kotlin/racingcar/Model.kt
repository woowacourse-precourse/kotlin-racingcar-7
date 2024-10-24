package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Model {
    private fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    private fun move(car: Car) {
        if (getRandomNumber() >= 4)
            car.go()
    }

    fun moveAll(cars: List<Car>) {
        cars.forEach { move(it) }
    }

    private fun getStatus(cars: List<Car>): List<Int> {
        return cars.map { it.getPos() }
    }
}