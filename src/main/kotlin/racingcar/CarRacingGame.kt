package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.constants.CarException
import racingcar.constants.GameMessage

class CarRacingGame {
    private lateinit var cars: List<Car>
    private lateinit var attempt: Attempt

    fun startRace() {
        cars = getCarNames()
        attempt = getAttemptCount()

        println(GameMessage.RESULT.message)
        repeat(attempt.getCount()) {
            raceRound()
            printRaceStatus()
        }
        printWinners()
    }

    private fun getCarNames(): List<Car> {
        println(GameMessage.CAR_INPUT.message)
        val names = Console.readLine().split(",").filter { it.isNotBlank() }
        require(names.distinct().size == names.size) { CarException.DUPLICATE.message }
        return names.map { Car(it) }
    }

    private fun getAttemptCount(): Attempt {
        println(GameMessage.TRY_INPUT.message)
        return Attempt.of(Console.readLine())
    }

    private fun raceRound() {
        cars.forEach { car ->
            car.moveForwardIfPossible()
        }
    }

    private fun printRaceStatus() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.distance)}")
        }
        println()
    }

    private fun printWinners() {
        val maxDistance = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == maxDistance }.joinToString(", ") { it.name }
        println(GameMessage.WINNER.message + winners)
    }
}