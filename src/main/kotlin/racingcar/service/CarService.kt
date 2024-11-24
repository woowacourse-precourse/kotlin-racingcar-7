package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

object CarService {
    private fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun createCars(rawInput: String): List<Car> {
        val carNames = rawInput.split(',').map { it }
        return carNames.map { Car(it, 0) }
    }

    fun moveAll(cars: List<Car>) {
        cars.forEach { it.move(getRandomNumber()) }
    }

    fun getStatus(cars: List<Car>): List<String> {
        return cars.map { "$it : " + "-".repeat(it.getPosition()) } // "pobi : ---" 같이 문자열 생성
    }

    fun getWinners(cars: List<Car>): String {
        val maxPos = cars.maxOf { it.getPosition() }
        val winners = cars.filter { it.getPosition() == maxPos }
        val result = winners.joinToString(", ")
        return result
    }
}