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

    fun runRace () {

    }

    fun addRacingCar() {
        racingCarsName.split(",").forEach { name ->
            racingCars.add(RacingCar(name, 0))
        }
    }

}