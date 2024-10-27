package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingCarGame(private val racingCarsName: String, private val raceCount: String) {

    var racingCars = mutableListOf<RacingCar>()

    fun start() {
        addRacingCar()
        repeat(raceCount.toInt()) {
            runRace()
        }
    }

    fun runRace() {
        racingCars.forEach { car ->
            forwardCar(car, generateRandomNumber())
        }
        printResultByStep()
    }

    fun forwardCar(racingCar: RacingCar, randomNumber: Int) {
        if (randomNumber >= FORWARD_CONDITION_NUMBER) racingCar.forwardCount += 1
    }

    fun findRaceWinners(): List<String> {
        val maxForwardCount = racingCars.maxOfOrNull { it.forwardCount }
        val winners = racingCars
            .filter { it.forwardCount == maxForwardCount }
            .map { it.name }
        return winners
    }

    fun addRacingCar() {
        racingCarsName.split(",").forEach { name ->
            racingCars.add(RacingCar(name, START_FORWARD_COUNT))
        }
    }

    fun printResultByStep() {
        racingCars.forEach { car ->
            print("${car.name} : ")
            printForwardCountByStep(car.forwardCount)
        }
        println()
    }

    private fun printForwardCountByStep(forwardCount: Int) {
        repeat(forwardCount) {
            print("-")
        }
        println()
    }

    fun generateRandomNumber(): Int = Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER)

    companion object {
        const val START_RANDOM_NUMBER = 0
        const val END_RANDOM_NUMBER = 9
        const val FORWARD_CONDITION_NUMBER = 4
        const val START_FORWARD_COUNT = 0
    }
}