package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Model {
    private fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it, 0) }
    }

    fun moveAll(cars: List<Car>) {
        cars.forEach { it.move(getRandomNumber()) }
    }

    fun getStatus(cars: List<Car>): List<Int> {
        return cars.map { it.getPos() }
    }
}