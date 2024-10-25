package racingcar.controller

import racingcar.model.RacingCar

class RacingCarController {
    fun createRacingCars(input: String): List<RacingCar> {
        val racingCarNames = splitRacingCarNames(input)
        return racingCarNames.map { racingCarName ->
            RacingCar(racingCarName)
        }
    }

    fun splitRacingCarNames(input: String) = input.split(",")

}