package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(
    private val cars: List<Car>,
    private val attempts: Int
) {

    fun start() {
        repeat(attempts) {
            race()
            printRaceStatus()
        }
        printWinners()
    }

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

    private fun printWinners() {
        val maxDistance = findMaxDistance()
        val winners = cars.filter { it.distance == maxDistance }
            .joinToString(", ") { it.name }
        println("최종 우승자 : $winners")
    }

    private fun findMaxDistance(): Int {
        return cars.maxOf { it.distance }
    }
}
