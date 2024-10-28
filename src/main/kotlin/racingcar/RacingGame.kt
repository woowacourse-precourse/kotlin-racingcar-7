package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>, private val attempts: Int) {

    private fun race() {
        cars.forEach { car ->
            val randomValue = Randoms.pickNumberInRange(0, 9)
            car.move(randomValue)
        }
    }

    private fun printRaceStatus() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.distance)}")
        }
        println()
    }
}
