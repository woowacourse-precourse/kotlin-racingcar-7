package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingCarGame(private val racingCarsName: String, private val raceCount: String) {

    var racingCars = mutableListOf<RacingCar>()

    fun start() {
        addRacingCar()
        for (i in 1..raceCount.toInt()) {
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
        if (randomNumber >= 4) racingCar.forwardCount += 1
    }

    fun printResultByStep() {
        racingCars.forEach { car ->
            print("${car.name} : ")
            printForwardCountByStep(car.forwardCount)
        }
        println()
    }

    fun addRacingCar() {
        racingCarsName.split(",").forEach { name ->
            racingCars.add(RacingCar(name, 0))
        }
    }

    private fun printForwardCountByStep(forwardCount: Int) {
        repeat(forwardCount) {
            print("-")
        }
        println()
    }

    fun generateRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

}